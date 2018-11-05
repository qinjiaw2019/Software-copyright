<?php

namespace App\Http\Utils;

class Response{
    const JSON = "json";
    /**
     * 综合xml和json格式封装函数(默认是返回json)
     * 请求可直接携带format=json或format=xml来获得对应格式的数据
     * @param $code 状态码
     * @param string $message 提示信息
     * @param array $data 数据
     * @param string $type 格式类型
     * @return string 格式化数据
     */
    public static function show($code,$message = "",$data = array(),$type=self::JSON){
        if(!is_numeric($code)) {
            return "";
        }
        $type = isset($_GET['format'])?$_GET['format']:self::JSON;

        $result = array(
            'errcode'=>$code,
        );
        //如果成功返回数据则不显示
        if($message!="")
            $result['msg'] = $message;
        //$data不为空才传递
        if(count($data)>0)
            $result['data'] = $data;

        if(strtolower($type)=="json"){
            //JSON格式
            return self::json($code,$message,$data);
        }elseif(strtolower($type)=="array"){
            //调试模式直接输出
            dump($result) ;
            exit;
        }elseif(strtolower($type)=="xml" ){
            //TODO 目前xml格式未开发完
            return self::xmlEncode($code,$message,$data);
        }else{
            //TODO 其他的格式,例如html,Object等格式
        }

        return "";
    }

    /**按json方式输出通信数据
     * @param $code  状态码
     * @param string $message 提示信息
     * @param array $data  数据
     *  @return string
     */
    public static function json($code,$message = "",$data = array()){

        if(!is_numeric($code)){
            return "";
        }

        $result = array(
            'errcode'=>$code,
        );
        //如果成功返回数据则不显示
        if($message!="")
            $result['msg'] = $message;
        //$data不为空才传递
        if(count($data)>0)
            $result['data'] = $data;

        return json_encode($result,JSON_UNESCAPED_UNICODE);
    }
    /**按xml方式输出通信数据
     * @param $code  状态码
     * @param string $message 提示信息
     * @param array $data  数据
     *  @return string
     */
    //TODO xml在谷歌显示不是xml结构  只能查看源代码才有xml结构
    public static function xmlEncode($code,$message = "",$data = array()){
        if(!is_numeric($code)){
            return "";
        }
        $result = array(
            'errcode'=>$code,
            'msg'=>$message,
        );
        //$data不为空才传递
        if(count($data)>0)
            $result['data'] = $data;

        header('Content-Type:text/xml; charset=UTF-8');
        $xml ="<?xml version='1.0' encoding='UTF-8'?>\n";
        $xml.="<root>\n";

        $xml.=self::xmlToEncode($data);

        $xml.="</root>\n";
        return $xml;
    }

    /**xml数据格式化
     * @param $data  数据
     * @return string xml格式数据
     */
    private static function xmlToEncode($data){
        $xml = $attr =  "";
        foreach($data as $key=>$value){
            //如果key是数字
            if(is_numeric($key)){
                $attr = "id='{$key}'";
                $key="item";
            }
            $xml.="<{$key} {$attr}>";
            $xml.=is_array($value)?self::xmlToEncode($value):$value;//如果value是数组则递归完成xml构造
            $xml.="</{$key}>\n";
        }
        return $xml;
    }
}