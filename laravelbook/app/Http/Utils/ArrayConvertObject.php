<?php

namespace App\Http\Utils;

/**
 *对象数组互转
 * Class ArrayConvertObject
 * @package App\Http\Utils
 */
class ArrayConvertObject{
    /**
     * 数组转对象
     * @param $array
     * @return StdClass
     */
    function array2object($array) {
        if (is_array($array)) {
            $obj = new \stdClass();

            foreach ($array as $key => $val){
                $obj->$key = $val;
            }
        }
        else { $obj = $array; }
        return $obj;
    }

    /**
     * 对象转数组
     * @param $object
     * @return mixed
     */
    function object2array($object) {
        if (is_object($object)) {
            foreach ($object as $key => $value) {
                $array[$key] = $value;
            }
        }
        else {
            $array = $object;
        }
        return $array;
    }
    /*
 $array = array('foo' => 'bar','one' => 'two','three' => 'four');
$obj = array2object($array);
print $obj->one; // output's "two"
$arr = object2array($obj);
print $arr['foo']; // output's bar
     */
}