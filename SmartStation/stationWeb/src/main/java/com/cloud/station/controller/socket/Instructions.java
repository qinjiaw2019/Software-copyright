package com.cloud.station.controller.socket;

import com.alibaba.fastjson.JSONArray;
import com.cloud.station.pojo.DepotInfo;
import com.cloud.station.pojo.DepotStationState;
import com.cloud.station.pojo.dto.CarDTO;
import com.cloud.station.service.*;
import com.cloud.station.service.cache.SocketManager;
import com.cloud.station.service.redis.StationStateRedis;
import com.cloud.station.utils.BeanTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 指令处理
 */
public class Instructions{
    public Map<String,String> devicesMap = new HashMap<>();//链接设备状态 appId-key
    //相关指令
    public final static String SYS_CHBT = "SYS+CHBT";//获取心跳时间(单位秒)
    public final static String DAT_LOCKED_0="DAT+LOCKED=0";//锁住指定车位
    public final static String DAT_LOCKED_1="DAT+LOCKED=1";//解锁车位
    public final static String DAT_UPSUM="DAT+UPSNUM";//更新数据(车位总数量)
    public final static String DATA_LEFT="DAT+LEFT";//剩余数量
    public final static String SYS_REST="SYS+REST";//重置模块设置信息

    public final static String DAT_TIME_INTERVAL = "DAT+TTL";//每多少毫秒同步一次数据

    public final static String SYS_CLOSED="SYS+CLOSED";//断开连接

    private static ApplicationContext applicationContext = null;
    @Autowired
    SocketManager socketManager;

    @Autowired
    StationOrderService stationOrderService;
    @Autowired
    DepotInfoService depotStationService;

    PrintStream out = null;
    Socket socket = null;

    public Instructions() {

    }
    public Instructions(Socket socket,PrintStream out) {
        this.out = out;
        this.socket = socket;
    }
    //保存连接
    private void saveConnection(Socket socket){
        //如果是新的socket
        Socket socket_ = this.socketManager.get(socket.getInetAddress().toString());
        if(socket_!=null) socketManager.add(socket);
    }

    public void parse(String cmd){
        //1.进行认证
      //  out.println("recived:"+cmd);

        StationStateRedis stationStateRedis = (StationStateRedis) BeanTools.getBean(StationStateRedis.class);
        stationOrderService = (StationOrderService)BeanTools.getBean(StationOrderService.class);
        PayService payService = (PayService) BeanTools.getBean(PayService.class);
        depotStationService = (DepotInfoService) BeanTools.getBean(DepotInfoService.class);

        if(cmd.contains("number")){//收到的是车牌信息
             CarDTO carDTO = JSONArray.parseObject(cmd,CarDTO.class);
              if(carDTO.getEndTime()!=null && carDTO.getEndTime()>0){//计算
                   float cusumMoney = payService.pay(carDTO.getStationId(),carDTO.getNumber());
                   out.println(cusumMoney);//总消费金额
              }else{//添加
                    //TODO 余额不足未处理
                 Integer rst = stationOrderService.addByCarNum(carDTO.getStationId(),carDTO.getNumber());
                 if(rst==1)out.println("OK");
                 else {
                     //TODO 查询黑名单 如果存在过则不能进入
                     out.println("ERROR");
                 }
              }
        }else if(cmd.contains("stationId")){
              DepotStationState depotStationState = JSONArray.parseObject(cmd,DepotStationState.class);
              stationStateRedis.save(depotStationState);
         }else if("ST+NUM".equals(getKeyFromCmd(cmd))){//获取停车场的数量(ST+NUM)
            String stationId_ = getValueFromCmd("ST+NUM",cmd);
            try{
                DepotInfo depotInfo = (DepotInfo) depotStationService.findByPrimaryKey(Long.valueOf(stationId_));
                out.println(depotInfo.getStationNum());
            }catch (Exception e){
                out.println("ERROR");
            }
        }else if("ST+LEFT".equals(getKeyFromCmd(cmd))){//获取当前停车场剩余数
            String stationId_ = getValueFromCmd("ST+LEFT",cmd);
            try{
                DepotStationState depotStationState = stationStateRedis.getByKey(Long.valueOf(stationId_));
                if(depotStationState!=null){
                    out.println(depotStationState.getLeft());
                }else{
                    DepotInfo depotInfo = (DepotInfo) depotStationService.findByPrimaryKey(Long.valueOf(stationId_));
                    out.println(depotInfo.getStationNum());
                }

            }catch (Exception e){
                out.println("ERROR");
            }
        }
    }

    /**
     * 从指令中提取值
     * 格式 key:value
     * @param key 指令key
     * @param str 字符串
     * @return
     */
    public String getValueFromCmd(String key,String str){
        String cmd = null;//指令值
        String str_ = str.trim();//去除前后空格
        if(!str_.startsWith(key)) return null;

        if(!str_.contains(":")) return null;

        cmd =  str_.substring(str.indexOf(":")+1);
        return cmd.trim();
    }

    /**
     * 从指令中得到KEY
     * @param cmd
     * @return
     */
    public String getKeyFromCmd(String cmd){
        String cmd_ = cmd.trim();
        if(cmd_.contains(":")){
            return cmd_.substring(0,cmd_.lastIndexOf(":")).trim();
        }else{
            return cmd.trim();
        }
    }

}
