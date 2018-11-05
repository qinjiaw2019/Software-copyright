<?php

namespace App\Http\Utils;
use Illuminate\Support\Facades\Hash;

/**
 * 密码加密
 * Class PasswordCrypt
 * @package App\Http\Utils
 */
class PasswordCrypt{

    /**
     * 密码加密
     * @param $password  加密密码
     * @return string
     */
    public function bcrypt($password){
        return bcrypt($password);
    }
    /**
     * 验证加密后的密码是否相同
     * @param $arg0
     * @param $arg1
     * @return bool
     */
    public function check($arg0,$arg1){
        if(Hash::check($arg0,$arg1))
            return true;
        else
            return false;
    }
}