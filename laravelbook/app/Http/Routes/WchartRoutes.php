<?php
namespace App\Http\Routes;
use Illuminate\Contracts\Routing\Registrar;

class WchartRoutes
{
    public function map(Registrar $router)
    {
        $router->group(['prefix'=>'Wchart','middleware' => 'cors','namespace'=>'Wchart'], function ($router) {
            $router->auth();
            /*获得微信菜单*/
            $router->get('getMenu',['uses'=>'WchartController@getMenu']);
            /*获得微信菜单列表*/
            $router->get('getMenuList',['uses'=>'WchartController@getMenuList']);
            /*获得微信菜单json格式字符串*/
            $router->get('getMenuJson',['uses'=>'WchartController@getMenuJson']);
            /*获得微信Token obj*/
            $router->get('getToken',['uses'=>'WchartController@getToken']);
            /*获得微信Token Value*/
            $router->get('getTokenValue',['uses'=>'WchartController@getTokenValue']);
            /*获得access_token的值*/
            $router->get('getAccessTokenValue',['uses'=>'WchartController@getAccessTokenValue']);
            /*获得appSecret的值*/
            $router->get('getSecretValue',['uses'=>'WchartController@getSecretValue']);
            /*获得EncodingAESKey的值*/
            $router->get('getEncodingAESKeyValue',['uses'=>'WchartController@getEncodingAESKeyValue']);

            /*微信消息列表*/
            $router->get('getMsg',['uses'=>'WchartController@getMsg']);
            /*微信消息总数*/
            $router->get('getMsgCount',['uses'=>'WchartController@getMsgCount']);
            /*添加微信消息*/
            $router->post('saveMsg',['uses'=>'WchartController@saveMsg']);
            /*用户关注时的信息*/
            $router->get('getSubscribe',['uses'=>'WchartController@getSubscribe']);

            /*添加一个粉丝*/
            $router->get('addFriend',['uses'=>'WchartFriendController@add']);
            /*分页列表*/
            $router->get('get_page',['uses'=>'WchartController@get_page']);
            /*微信粉丝分页列表*/
            $router->get('get_page_f',['uses'=>'WchartFriendController@get_page']);
            /*获得设置基本信息*/
            $router->get('getBaseInfo',['uses'=>'WchartController@getBaseInfo']);

            $router->any('test',['uses'=>'IndexController@responseMsg']);
            $router->any('test1',['uses'=>'IndexController@menu']);



        });
    }
}



