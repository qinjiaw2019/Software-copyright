<?php
namespace App\Http\Routes;
use Illuminate\Contracts\Routing\Registrar;

class ReaderRoutes
{
    public function map(Registrar $router)
    {
        $router->group(['prefix'=>'Reader','middleware' => 'cors','namespace'=>'Reader'], function ($router) {
            $router->auth();

            $router->get('get',['uses'=>'ReaderController@get']);
            $router->get('getType',['uses'=>'ReaderController@getType']);
            $router->get('register',['uses'=>'ReaderController@register']);
            /*解除绑定*/
            $router->post('unregister',['uses'=>'ReaderController@unregister']);
            $router->post('login',['uses'=>'ReaderController@login']);



        });
    }
}



