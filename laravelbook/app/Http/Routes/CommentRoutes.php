<?php
namespace App\Http\Routes;
use Illuminate\Contracts\Routing\Registrar;

class CommentRoutes
{
    public function map(Registrar $router)
    {
        $router->group(['prefix'=>'Comment','middleware' => 'cors','namespace'=>'Comment'], function ($router) {
            $router->auth();

            /*查询评论*/
            $router->get('get',['uses'=>'CommentController@get']);
            /*添加评论*/
            $router->post('add',['uses'=>'CommentController@add']);
            /*删除评论*/
            $router->post('del',['uses'=>'CommentController@del']);
a
        });
    }
}



