package com.cloud.station.controller.websocket;


import com.alibaba.fastjson.JSONArray;
import com.cloud.station.pojo.dto.AddressDTO;
import com.cloud.station.pojo.dto.MapAddressDTO;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * 停车场状态信息WebSocket
 */
@ServerEndpoint("/station/websoket")
@Component
public class StationSateWebSocket {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //处理线程
    private StationStateThread stationStateThread;
    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        addOnlineCount();           //在线数加1

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        subOnlineCount();           //在线数减1
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stationStateThread.shut();
    }

    /**
     * 收到客户端消息后调用的方法
     * @param address 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String address, Session session,@PathParam("client-id") String clientId) {
        AddressDTO addressDTO = JSONArray.parseObject(address,AddressDTO.class);
        try{
            if(stationStateThread==null)stationStateThread = new StationStateThread(session,addressDTO);
            if(session.isOpen() && stationStateThread!=null)stationStateThread.start();
        }catch (Exception e){
            try {
                session.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stationStateThread.shut();
        error.printStackTrace();
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        StationSateWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        StationSateWebSocket.onlineCount--;
    }
}