<?php
namespace App\Http\Routes;
use Illuminate\Contracts\Routing\Registrar;

class AdminRoutes
{
    public function map(Registrar $router)
    {
        $router->group(['prefix'=>'Admin','middleware' => 'cors','namespace'=>'Admin'], function ($router) {
            $router->auth();
            /*管理员登陆*/
            $router->post('login',['uses'=>'LoginController@login']);
            /*管理员注册*/
            $router->post('register','LoginController@register');
            /*登出*/
            $router->any('logout',['uses'=>'LoginController@logout']);

        });
    }
}



