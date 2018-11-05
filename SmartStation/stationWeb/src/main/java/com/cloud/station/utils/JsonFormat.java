package com.cloud.station.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.Date;
import java.util.List;

/**
 *
 * DESC: 封装一个结果类型的字符串，包括success和msg两个字段
 */
public class JsonFormat {
    //格式化日期
    private static String dateFormat;
    static {
        dateFormat = "yyyy-MM-dd HH:mm:ss";
    }

    private static SerializeConfig mapping = new SerializeConfig();
    static {
        //jackson默认写出的时间数据为时间戳， 这里修改为相应模式的时间数据输出格式
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
    }

    /**
     * 将对象或集合转换为json字符串
     * @param obj
     * @return
     */
    public final static String toString(Object obj){
        return JSONObject.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue);
    }

    /**
     * 将对象或集合转换为json字符串
     * @param obj
     * @return
     */
    public final static String toStringWithoutNull(Object obj){
        return JSONObject.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将结果字符串转换为标准结果集
     * @param success
     * @param msg
     * @return {"success":success,"msg":msg}
     */
    public final static String toStringResult(boolean success, String msg){
        return String.format("{\"success\":%s,\"msg\":\"%s\"}", success?"true":"false", msg);
    }

    public final static String toStatusResult(int status, Object data){
        return String.format("{\"status\":%s,\"data\":%s}", status, toString(data));
    }

//    public final static String toStatusResult(ResultBean data){
//        if (data.getData() instanceof String)
//            return data.toString();
//        else
//            return toStatusResult(data.getStatus(), data.getData());
//    }

    /**
     * 将对象转换为标准结果集
     * @param success
     * @param msg
     * @return {"success":success,"msg":msg}
     */
    public final static String toObjectResult(boolean success, Object msg){
        if (msg != null)
            return String.format("{\"success\":%s,\"msg\":%s}", success, JSONObject.toJSONStringWithDateFormat(msg, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue));
        else //把null集合转换为[]，是为了kendo ui dataSource，直接返回null，会出现Status code=200的异常
            return String.format("{\"success\":%s,\"msg\":\"[]\"}", success);
    }

    public final static String toString(String key, Object msg){
        return String.format("{\"%s\":%s}", key, JSONObject.toJSONStringWithDateFormat(msg, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue));
    }

    public final static String toPageString(Integer total, List data){
        if (total == null || total == 0)
            return emptyPageString();

        return String.format("{\"total\":%s, \"data\":%s}", total, JSONObject.toJSONStringWithDateFormat(data, "yyyy-MM-dd HH:mm:ss"));
    }

    public final static String toPageString(List data){
        if (data.size() == 0)
            return emptyPageString();

        return String.format("{\"total\":%s, \"data\":%s}", data.size(), JSONObject.toJSONStringWithDateFormat(data, "yyyy-MM-dd HH:mm:ss"));
    }

    public final static String emptyPageString(){
        return "{\"total\":0, \"data\":\"\"}";
    }
}