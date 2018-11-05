<?php
namespace App\Http\Controllers\Reader;



use App\Http\Controllers\BaseController\BaseController;
use App\Http\Model\Reader;
use App\Http\Model\ReaderType;

class ReaderController extends BaseController{
    private $model;
    function __construct()
    {
        $this->model = new Reader();
    }

    public function get(){
        $m = $this->model->test();
        return response_ins()->show(0,"success",$m);
    }
    public function getType(){
        $m = new ReaderType();
        return response_ins()->show(0,"success",$m->test());
    }
    public function register(){
        $param = request_ins()->all();
        $check = $this->model->getBy("wexin_num",$param['wexin_num']);
        $m = $this->model->add(request_ins()->all());
        if($check)//已注册
            return response_ins()->show(1,"failed",$m);
        else//如果没有注册则注册
            return response_ins()->show(0,"success",$m);
    }
    public function unregister(){
        $weixin_num = request_ins()->rq('wexin_num');
        if(!$weixin_num)
            return response_ins()->show(1,"wexin_num is required");
        $m = $this->model->delete_reader($weixin_num);
        return $m ?
            response_ins()->show(0,"success") :
            response_ins()->show(1,"delete failed");
    }
    public function login(){
        $username = request_ins()->rq('username');
        $password = request_ins()->rq('password');
        if(!$username || !$password)
            return response_ins()->show(1,"username and password are required");
        $m = $this->model->login($username,$password);
        $reader_info = (new Reader())->getBy('acount',$username);
        return $m ?
            response_ins()->show(0,"success",$reader_info) :
            response_ins()->show(1,"login failed");
    }
}