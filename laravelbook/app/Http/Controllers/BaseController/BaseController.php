<?php
namespace App\Http\Controllers\BaseController;

use \App\Http\Controllers\Controller;
use App\Http\Utils\Common;
use App\Http\Utils\HttpRequest;
use App\Http\Utils\PasswordCrypt;
use App\Http\Utils\Response;
use App\Http\Utils\SessionManager;

class BaseController extends Controller{
    /**
     * 实例化Response类
     * @return Response
     */
    public function responseData(){
        return new Response();
    }
    

    /**
     * 实例化SessionManager类
     * @return SessionManager
     */
    public function sessionManager(){
        return new SessionManager();
    }

    /**
     * 对sessionManager的包装
     * @return SessionManager
     */
    public function SM(){
        return $this->sessionManager();
    }

    /**
     *实例化PasswordCrypt类
     * @return PasswordCrypt
     */
    public function pass_encrypt(){
        return new PasswordCrypt();
    }

    /**
     * 实例化HttpRequest类
     * @return HttpRequest
     */
    public function http_request(){
        return new HttpRequest();
    }


}