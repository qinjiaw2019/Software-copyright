package com.cloud.station.service.cache;

import java.net.Socket;
import java.util.List;
import java.util.Map;

/**
 * socket连接管理类
 */
public interface SocketManager {

    public void add(Socket socket);//z增加一个socket

    public void delete(String key);//删除一个socket

    public void clear();//清空所有的Socket连接

    public Socket get(String key);//根据key查询指定的Socket

    public void update(Socket socket);//更新


    public Integer count();//统计总数

    public List getOtherSocket(Socket socket);//获得其他的Socket连接
}
