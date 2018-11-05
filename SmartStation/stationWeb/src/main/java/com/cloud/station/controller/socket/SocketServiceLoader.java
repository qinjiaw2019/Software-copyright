package com.cloud.station.controller.socket;

import com.cloud.station.service.cache.SocketManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 将socket service随tomcat启动
 * @author zhangzhongwen
 *
 */
@WebListener
public class SocketServiceLoader implements ServletContextListener{
    //socket server 线程
    private SocketThread socketThread;


    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("liting: contextDestroyed");
        if(null!=socketThread && !socketThread.isInterrupted())
        {
            socketThread.closeSocketServer();
            socketThread.interrupt();
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("liting: contextInitialized");

        if(null==socketThread)
        {
            //新建线程类
            socketThread=new SocketThread(null);
            //启动线程
            socketThread.start();
        }
    }
}
