<?php

namespace App\Http\Utils;
/**
 * Session管理
 * Class SessionManager
 * @package App\Http\Utils
 */
class SessionManager{
    /**
     * 存入一组数据到session中
     * @param $key  键
     * @param $val 值
     * @param $group 组名
     * @return array|bool
     */
    public function put($key,$val,$group){
        $arr = array(
            $key=>$val
        );
        return $this->puts($arr,$group);
    }

    /**
     * 将一组数据存入session中
     * @param $arr 带存入session的数组
     * @param $arr 组名
     * @return bool|array  false| session分组名 如果没有
     */
    public function puts($arr,$group=""){
        /*如果参数不是数组则返回false*/
        if(!is_array($arr))
            return false;

        $sess_arr = array();
        if($group!=""){
            session()->put($group,[]);//分配一个session组
            $sess_arr = session()->get($group);//获得session组
        }
        /*存入session中*/
        foreach($arr as $k=>$v){
            if(is_null($sess_arr))
                session()->put($k,$v);
            else
                $sess_arr[$k] = $v;
            session($group,null);//将原来的session组删除
            session()->put($group,$sess_arr);//存入新的session组
        }
        return $group;
    }
}