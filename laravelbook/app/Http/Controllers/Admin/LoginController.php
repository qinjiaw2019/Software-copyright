<?php
namespace App\Http\Controllers\Admin;



use App\Http\Controllers\BaseController\BaseController;
use App\Http\Model\Admin;
use App\Http\Utils\Common;
use Illuminate\Support\Facades\Hash;

class LoginController extends BaseController{
        private $admin;
        function __construct()
        {
            $this->admin = new Admin();
        }

        public function login(){
            $check = $this->has_username_password();
            //检查用户名和密码
            if(!$check)
                return response_ins()->show(40003, 'username and password are required');

            $username = $check[0];
            $password = $check[1];

            //判断用户名和密码合法性
            if(!($this->admin->check_username_password($username,$password)))
                return response_ins()->show(40004, 'username or password error');
            //把用户名写入到session的user组中
            $this->SM()->put($username,$password,"admin");

            //获得用户信息
            $user = $this->admin->getByUserName($username);
            $res = array(
                'id' => $user->uid,
                'account'=>$username,
                'name'=>$user->realname,
            );
            return response_ins()->show(0, 'success',$res);
        }

    /**
     * 登出
     * @return string
     */
        public function logout(){
            session()->forget('admin');//如果session分组存在则删除
            return response_ins()->show(0, 'success');
        }

        /**
         * 检查参数中是否存在用户名和密码
         * @return array|bool 返回用户名和密码 |fase
         */
        public function has_username_password(){
            $username = request_ins()->rq('username');
            $password = request_ins()->rq('password');
            if($username && $password)
                return [$username,$password];
            else
                return false;
        }

    /**
     * 用户注册
     * @return string
     */
        public function register(){
            $check = $this->has_username_password();

            if(!$check)
                return response_ins()->show(40003, 'username and password are required');

            $username = $check[0];
            $password = $check[1];

            $user_exists = $this->admin->check_username($username);
            if($user_exists)
                return response_ins()->show(40005, '用户已存在');
            //密码加密处理
            $code_password = $this->pass_encrypt()->bcrypt($password);

            //保存数据
            if($this->admin->add($username,$code_password))
                return response_ins()->show(0, 'success', ['username'=>$username]);
            else
                return response_ins()->show(1, 'failed');
        }
}