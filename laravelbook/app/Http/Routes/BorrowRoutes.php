<?php
namespace App\Http\Routes;
use Illuminate\Contracts\Routing\Registrar;

class BorrowRoutes
{
    public function map(Registrar $router)
    {
        $router->group(['prefix'=>'Borrow','middleware' => 'cors','namespace'=>'Borrow'], function ($router) {
            $router->auth();

            /*预约图书*/
            $router->post('add',['uses'=>'BorrowController@add']);
            /*借阅图书*/
            $router->post('borrow_book',['uses'=>'BorrowController@borrow_book']);
            /*预约记录分页*/
            $router->get('get_page',['uses'=>'BorrowController@get_page']);
            /*借阅图书分页*/
            $router->get('get_page_b',['uses'=>'BorrowController@get_page_b']);
            /*查询所有指定读者的所有预约信息*/
            $router->get('get_reader_all_bow',['uses'=>'BorrowController@get_reader_all_bow']);
            /*查询所有指定读者的所有图书借阅信息*/
            $router->get('get_reader_all_bow_b',['uses'=>'BorrowController@get_reader_all_bow_b']);


        });
    }
}



