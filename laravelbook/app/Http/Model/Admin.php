<?php

namespace App\Http\Model;

use App\Http\Model\BaseModel\BaseModel;
use App\Http\Utils\PasswordCrypt;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

class Admin extends BaseModel
{
    protected $table = 'admin';
    protected $primaryKey = "uid";

    /**
     * 检查用户名和密码是否同时匹配
     * @param $username 用户名
     * @param $password 密码
     * @return bool
     */
    public function check_username_password($username,$password){
        //检查用户名是否存在
        $user = $this->where('username',$username)->first();
        if(!$user)
            return false;

        /*检查密码是否正确*/
        $hased_password =$user->password;
        if((new PasswordCrypt())->check($password,$hased_password))
            return true;
        return false;
    }

    /**
     * 检查用户名是否存在
     * @param $username  用户名
     * @return bool
     */
    public function check_username($username){
        //检查用户名是否存在
        $user = $this->where('username',$username)->first();
        if(!$user)
            return false;
        return true;
    }

    /**
     * 简单添加一个用户(用户名，密码)
     * @param $username 用户名
     * @param $password 密码
     * @return bool
     */
    public function add($username,$password){
        $this->username = $username;
        $this->password = $password;
        return $this->save() ? true : false;
    }

    /**
     * 根据用户名查询账号信息
     * @param $username 用户名
     * @return mixed
     */
    public function getByUserName($username){
        $user = $this->where('username',$username)->first();
        return $user;
    }
}