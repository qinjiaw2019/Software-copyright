<?php

namespace App\Http\Utils;
use Illuminate\Support\Facades\Hash;
use Request;
class Common{

    /**获取参数
     * 如果没有参数则返回所有参数
     * 如果有参数则返回参数对应的值
     * @param null $key 关键字
     * @param null $default 默认值
     * @return mixed
     */
    public function rq($key=null,$default=null){//request
        if(!$key) return Request::all();
        return Request::get($key,$default);
    }

    /**
     * 获得所有参数
     * @return mixed
     */
    public function all(){
        return Request::all();
    }
    /**
     * 简单格式化日期
     * @param string $format  日期格式字符串
     * @return bool|string 返回格式化的日期
     */
    public function simpleData($format='Y-m-d H;i:s'){
        return date($format,time());
    }

    /**
     * 将一维数组转换为字符串
     * @param array $arr  一维数组
     * @param string $ch  分割符
     * @return string 字符串
     */
    public function array2string($arr = array(),$ch=','){
        $str = "";
        if(is_array($arr))
        foreach($arr as $k=>$v){
            $str .=$ch.$v;
        };
        $str = ltrim($str,',');
        return $str;
    }
    public function collection_toArray($arg){
        $arg = array_map(function ($value) {
            return (array)$value;
        }, $arg);
    }
}