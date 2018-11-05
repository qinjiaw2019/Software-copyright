package com.cloud.station.controller.socket;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;


/**
 * 多线程处理socket接收的数据
 */
public class SocketOperate extends Thread{
    private Socket socket;
    @Autowired

    public SocketOperate(Socket socket) {
        this.socket=socket;
    }
    @SuppressWarnings("unused")
    public void run()
    {
        PrintStream out = null;
        BufferedReader buf =null;
        Instructions instructions = null;
        boolean flag =true;
        try{
            while(flag){
                //获取Socket的输出流，用来向客户端发送数据
                out = new PrintStream(socket.getOutputStream());
                //获取Socket的输入流，用来接收从客户端发送过来的数据
                buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                instructions = new Instructions(socket,out);
                //接收从客户端发送过来的数据
                String str =  buf.readLine();

                if(str == null || "".equals(str)){
                    flag = false;
                }else{
                    instructions.parse(str);
                }
            }
            out.close();
            socket.close();
//            socket.setSoTimeout(30000);//设置读操作超时时间30 s
        }catch(Exception ex){
            out.println("Connection closed;");
            flag = false;
            ex.printStackTrace();
        }
    }
}