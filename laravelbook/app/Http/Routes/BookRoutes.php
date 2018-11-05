<?php
namespace App\Http\Routes;

use App\Http\Model\Book;
use Illuminate\Contracts\Routing\Registrar;


class BookRoutes
{
    public function book_ins(){
        return new Book();
    }
    public function map(Registrar $router)
    {
        $router->group(['prefix'=>'Book','middleware' => 'cors','namespace'=>'Book'], function ($router) {
            $router->auth();
            /*查询图书分类*/
            $router->get('getMenu','BookController@getMenu');
            /*添加图书分类*/
            $router->post('addType','BookController@addTypeById');
            /*修改图书分类*/
            $router->post('updateType','BookController@updateTypeById');
            /*删除图书分类*/
            $router->post('deleteType','BookController@deleteTypeById');

            /*查询图书信息*/
            $router->get('get','BookController@get');
            /*查询图书总数*/
            $router->get('getCount','BookController@getCount');
            /*根据名称查询图书信息*/
            $router->get('getByName','BookController@getByName');
            /*根据分类id查询图书信息*/
            $router->get('getByTypeId','BookController@getByTypeId');
            /*查询分类下的所有图书总数*/
            $router->get('countByTypeId','BookController@countByTypeId');

            /*保存图书信息*/
            $router->post('saveInfo','BookController@saveInfo');
            /*更新图书信息*/
            $router->post('updateInfo','BookController@updateInfo');
            /*删除图书信息*/
            $router->post('deleteById','BookController@deleteById');
            /*图书搜索*/
            $router->get('search','BookController@search');

            /*获取热销图书*/
            $router->get('getTop','BookController@getTop');


        });
    }
}



