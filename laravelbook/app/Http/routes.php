<?php

/*Util/Common实例*/
function request_ins(){
    return new \App\Http\Utils\Common();
}
/*Util/Common实例*/
function common(){
    return new \App\Http\Utils\Common();
}
/*Util/Response实例*/
function response_ins(){
    return new \App\Http\Utils\Response();
}
/*微信交互首页*/

Route::group(['prefix'=>'Wchart','middleware' => 'cors','namespace'=>'Wchart'], function ($router) {
    Route::any('Index','IndexController@index');
});

/*
|--------------------------------------------------------------------------
| Routes File
|--------------------------------------------------------------------------
|
| Here is where you will register all of the routes in an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the controller to call when that URI is requested.
|
*/
Route::get('/', function () {
    return view('welcome');
});
//Event::listen('404',function(){
//    return Response::error('404');
//});

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| This route group applies the "web" middleware group to every route
| it contains. The "web" middleware group is defined in your HTTP
| kernel and includes session state, CSRF protection, and more.
|
*/

Route::group(['middleware' => ['web']], function () {
    //
});