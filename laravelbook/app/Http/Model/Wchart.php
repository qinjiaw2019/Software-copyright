<?php

namespace App\Http\Model;

use App\Http\Model\BaseModel\BaseModel;
use Illuminate\Support\Facades\DB;

class Wchart extends BaseModel
{
    protected $table = 'wchart_menu';
    protected $primaryKey = "id";

    /**
     * 分页列表
     * @param $page
     * @param $limit
     * @return mixed
     */
    public function get_page($page,$limit){
        $skip = ($page - 1) * $limit;
        $model = $this->limit($limit)
            ->skip($skip)
            ->get();
        return $model;
    }

    /**
     * 获得微信菜单 不包括没有启用的
     * @return string
     */
    public function getMenu(){
            //开始拼接数据
            $data = '{"button":[';
            //取出一级菜单
            $parent = DB::select('select * from wchart_menu where pid=0 and expire!=0 order by level desc limit 3');
            $k = 1;
            foreach($parent as $key=>$vo){
                //主菜单
                $data.='{"name":"'.$vo->m_name.'",';

                //取出子菜单
                $sql = "select * from wchart_menu where pid=".$vo->id;
                $sql.=" and expire!=0 order by level desc limit 5";
                $child = DB::select($sql);
                //获得父类下的子菜单数量
                $c_count = $this->where("pid",$vo->id)->limit(5)->count();
                $num=1;
                //拼接子菜单
                if($child!=false){
                    $data.='"sub_button":[';
                    foreach($child as $voo){
                        $type = $voo->m_type;
                        switch ($type){
                            case 'click'://点击推事件
                                $data.='{"type":"click","name":"'.$voo->m_name.'","key":"'.$voo->keyword.'"},';
                                break;
                            case 'view'://跳转URL
                                $data.='{"type":"view","name":"'.$voo->m_name.'","url":"'.$voo->url.'"},';
                                break;
                            case 'scancode_waitmsg'://扫码推事件且弹出“消息接收中”提示框
                                $data.='{"type":"scancode_waitmsg","name":"'.$voo->m_name.'","key":"'.$voo->keyword.'","sub_button":[]},';
                                break;
                            case 'scancode_push'://扫码推事件
                                $data.='{"type":"scancode_push","name":"'.$voo->m_name.'","key":"'.$voo->keyword.'","sub_button":[]},';
                                break;
                            case 'pic_sysphoto'://弹出系统拍照发图
                                $data.='{"type":"pic_sysphoto","name":"'.$voo->m_name.'","key":"'.$voo->keyword.'","sub_button":[]},';
                                break;
                            case 'pic_photo_or_album'://弹出拍照或者相册发图
                                $data.='{"type":"pic_photo_or_album","name":"'.$voo->m_name.'","key":"'.$voo->keyword.'","sub_button":[]},';
                                break;
                            case 'pic_weixin'://弹出微信相册发图器
                                $data.='{"type":"pic_weixin","name":"'.$voo->m_name.'","key":"'.$voo->keyword.'","sub_button":[]},';
                                break;

                        }
// 					if($num==$count) $data.='{"type":"'.$type.'","name":"'.$voo['name'].'","url":"'.$voo['url'].'"}';
// 					else $data.='{"type":"'.$type.'","name":"'.$voo['name'].'","url":"'.$voo['url'].'"},';
// 					$num++;
                    }
                    $data = rtrim($data,',');
                    $data.=']';

                }else{//拼接主菜单其余部分
                    switch ($vo->m_type){
                        case 'click':
                            $data.='"type":"click","key":"'.$vo->keyword.'"';
                            break;
                        case 'view':
                            $data.='"type":"view","url":"'.$vo->keyword.'"';
                            break;
                        case 'location_select'://弹出地理位置选择器
                            $data.='"type":"location_select","name":"'.$vo->m_.name.'","key":"'.$vo->keyword.'"';
                            break;
                        case 'media_id'://下发消息（除文本消息）
                            $data.='"type":"media_id","name":"'.$vo->m_.name.'","media_id":"'.$vo->media_id.'"';
                            break;
                        case 'view_limited'://跳转图文消息URL
                            $data.='"type":"media_id","name":"'.$vo->m_.name.'","media_id":"'.$vo->media_id.'"';
                            break;
                    }
                }

                if($k==3){

                    $data.='}';

                }else{

                    $data.='},';

                }

                $k++;
            }

            $data.=']}';
            return $data;
    }
    public function getMenuList(){
        $res = DB::select("select * from wchart_menu");
        return $res;
    }

    /**
     * 获得微信关注消息
     * @return mixed
     */
    public function getSubscribe(){
        $res = DB::select("select content from wchart_msg where eventtype='subscribe'");
        return $res[0]->content;
    }

    /**
     * 获得微信Token 信息
     * @return mixed
     */
    public function getToken(){
        $res = DB::select("select id,set_name,value,note from wchart_setting where set_name='token'");
        return $res;
    }

    /**
     * 获得微信access_token
     * @return mixed
     */
    public function getAccessToken(){
        $res = DB::select("select id,set_name,value,note from wchart_setting where set_name='access_token'");
        return $res;
    }

    /**
     * 获得微信access_token的值
     * @return mixed
     */
    public function getAccessTokenValue(){
        $obj = $this->getAccessToken();
        return $obj[0]->value;
    }

    /**
     * 更新access_token
     * @param $access_token access_token
     * @return mixed
     */
    public function saveAccessToken($access_token){
        $sql = "update wchart_setting set value='".$access_token."' where set_name='access_token'";
        $res = DB::update($sql);
        return $res;
    }
    /**
     * 获得access_token的过期时间expire_time
     * @return mixed
     */
    public function getExpireTime(){
        $res = DB::select("select id,set_name,value,note from wchart_setting where set_name='expire_time'");
        return $res;
    }

    /**
     * 获得access_token的过期时间expire_time 的值
     * @return mixed
     */
    public function getExpireTimeValue(){
        $obj = $this->getExpireTime();
        return $obj[0]->value;
    }

    /**
     * 更新expire_time
     * @param $expire_time expire_time
     * @return mixed
     */
    public function SaveExpireTime($expire_time){
        $sql = "update wchart_setting set value='".$expire_time."' where set_name='expire_time'";
        $res = DB::update($sql);
        return $res;
    }

    /**
     * 获得微信appid对象
     * @return mixed
     */
    public function getAppId(){
        $res = DB::select("select id,set_name,value,note from wchart_setting where set_name='appid'");
        return $res;
    }

    /**
     * 获得微信appid对象的值
     * @return mixed
     */
    public function getAppIdValue(){
        $res = $this->getAppId();
        return $res[0]->value;
    }


    /**
     * 获得微信secret对象
     * @return mixed
     */
    public function getSecret(){
        $res = DB::select("select id,set_name,value,note from wchart_setting where set_name='secret'");
        return $res;
    }

    /**
     * 获得微信secret对象的值
     * @return mixed
     */
    public function getSecretValue(){
        $res = $this->getSecret();
        return $res[0]->value;
    }

    public function getEncodingAESKey(){
        $res = DB::select("select id,set_name,value,note from wchart_setting where set_name='EncodingAESKey'");
        return $res;
    }
    public function getEncodingAESKeyValue(){
        $res = $this->getEncodingAESKey();
        return $res[0]->value;
    }

    /**
     * 微信消息
     * @param $skip
     * @param $limit
     * @return mixed
     */
    public function getMsgList($skip,$limit){
        $res = DB::select('select * from wchart_msg  order by createtime desc limit  ?,? ',[$skip,$limit]);
        return $res;
    }

    /**
     * 查询消息总数
     */
    public function getMsgCount(){
        $res = DB::table("wchart_msg")->count();
        return $res;
    }

    /**
     * 保存文本消息
     * @param $input
     * @return mixed
     */
    public function saveMsgTypeOfText($input){
        $sql = "insert into wchart_msg( keyword,content,createtime,msgtype) VALUES(?,?,?,?)";
        $res = DB::insert($sql,[$input['keyword'],$input['content'],$input['createtime'],'text']);
        return $res;
    }

}