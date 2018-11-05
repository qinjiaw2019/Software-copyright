package com.cloud.station.controller.socket;

import com.cloud.station.conf.ConfigurationManager;
import com.cloud.station.constant.ConstantsKey;
import com.cloud.station.service.cache.SocketManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket 线程类
 * @author zhangzhongwen
 *
 */
public class SocketThread extends Thread{
    private ServerSocket serverSocket = null;


    public SocketThread(ServerSocket serverScoket){
        try {
            if(null == serverSocket){
                this.serverSocket = new ServerSocket(8899);//TODO 这里要使用配置文件进行配置
                System.out.println("socket start");
            }
        } catch (Exception e) {
            System.out.println("SocketThread创建socket服务出错");
            e.printStackTrace();
        }

    }

    public void run(){

        while(!this.isInterrupted()){
            try {
                Socket socket = null;
                socket = serverSocket.accept();
                if(null != socket){
                    //处理接受的数据
                    new SocketOperate(socket).start();
                }
//                socket.setSoTimeout(300000);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void closeSocketServer(){
        try {
            if(null!=serverSocket && !serverSocket.isClosed())
            {
                serverSocket.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }







}