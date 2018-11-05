package com.cloud.station.controller.websocket;

import com.alibaba.fastjson.JSONObject;
import com.cloud.station.algorithm.Distance;
import com.cloud.station.pojo.DepotInfo;
import com.cloud.station.pojo.DepotStationState;
import com.cloud.station.pojo.dto.AddressDTO;
import com.cloud.station.pojo.dto.Position;
import com.cloud.station.pojo.dto.StationStateDTO;
import com.cloud.station.service.DepotInfoService;
import com.cloud.station.service.redis.StationStateRedis;
import com.cloud.station.utils.BeanTools;

import javax.websocket.Session;
import java.io.IOException;
import java.util.*;

/**
 * 停车场状态信息线程
 */
public class StationStateThread extends Thread{
    private Session session;
    private boolean isRunning;

    private DepotInfoService depotInfoService;
    StationStateRedis stationStateRedis;


    private AddressDTO addressDTO;//封装的地址类
    public StationStateThread(Session session,AddressDTO addressDTO) {
        this.session = session;
        this.addressDTO = addressDTO;

        //从spring容器中获取bean
        depotInfoService = (DepotInfoService) BeanTools.getBean(DepotInfoService.class);

        if(session.isOpen() && addressDTO!=null)
            this.isRunning = true;
        else
            this.isRunning = false;
    }

    @Override
    public void run() {
         stationStateRedis = (StationStateRedis) BeanTools.getBean(StationStateRedis.class);
         List<DepotInfo> list = init();//获取数据
        List<StationStateDTO> stateList = new ArrayList<>();//状态信息
        while (isRunning){
            if(!session.isOpen()){
                isRunning = false;
            }else{

                try {
                    Thread.sleep(1000);

                    //监控当前车位状态
                    stateList.clear();
                    for(DepotInfo di:list){
                        StationStateDTO ss = new StationStateDTO();

                        DepotStationState ds = stationStateRedis.getByKey(di.getId());//获取状态信息

                        if(ds!=null){
                            ss.setLeft(ds.getLeft());
                        }else{
                            ss.setLeft(di.getStationNum());
                        }
                        ss.setStationId(di.getId());
                        ss.setLastTime(new Date().getTime());
                        stateList.add(ss);
                    }


                    StationStateDTO css = new StationStateDTO();
                    DepotStationState currrentDs = stationStateRedis.getByKey(addressDTO.getSid());
                    if(currrentDs!=null){
                        css.setLeft(currrentDs.getLeft());
                    }else{
                        DepotInfo depotInfo = (DepotInfo) depotInfoService.findByPrimaryKey(addressDTO.getSid());
                        css.setLeft(depotInfo.getStationNum());
                    }
                    css.setStationId(addressDTO.getSid());
                    css.setLastTime(new Date().getTime());



                    Map map = new HashMap();
                    map.put("state_info",stateList);
                    map.put("count",1);
                    map.put("current",css);
                    this.session.getBasicRemote().sendText(JSONObject.toJSONString(map));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void shut(){
        this.isRunning = false;
    }

    public List<DepotInfo> getDataFromDB(Double lat,Double lng,Double distance){
        //计算范围
        Position position = Distance.calcPosition(lat,lng,distance);
        List<DepotInfo> list =depotInfoService.getByLatAndLon(position,addressDTO.getPage(),addressDTO.getLimit());

        if(list.isEmpty() || list.size()<addressDTO.getLimit()){
           List list_ =  stationStateRedis.getByLatAndLon(position,addressDTO.getLimit()-list.size());//从缓存获取
           list.addAll(list_);
        }
        return list;
    }

    /**
     * 首次进入获得数据
     */
    public List init(){
        //重数据库查询
        List<DepotInfo> list = getDataFromDB(addressDTO.getLat(),addressDTO.getLng(),
                addressDTO.getDistance());

        Double distance = addressDTO.getDistance();//当前搜索范围
        Double max_distance = 2*addressDTO.getDistance();//TODO 最大搜索范围 暂定2倍距离
        while(list==null){//如果没有找到则扩大范围查找
            distance+=addressDTO.getStep();//扩大范围
            list = getDataFromDB(addressDTO.getLat(),addressDTO.getLng(),distance);

            if(distance>=max_distance)break;//达到最大搜索范围后还没有就跳出循环
        }
        try {
            Map map = new HashMap();
            map.put("station_info",list);
            map.put("count",0);
            map.put("current",depotInfoService.findByPrimaryKey(addressDTO.getSid()));
            this.session.getBasicRemote().sendText(JSONObject.toJSONString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;
    }
}
