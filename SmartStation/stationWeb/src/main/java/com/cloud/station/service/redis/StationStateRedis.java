package com.cloud.station.service.redis;

import com.cloud.station.constant.ConstantsKey;
import com.cloud.station.pojo.CarNumberUsed;
import com.cloud.station.pojo.DepotInfo;
import com.cloud.station.pojo.DepotStationState;
import com.cloud.station.pojo.dto.CarDTO;
import com.cloud.station.pojo.dto.Position;
import com.cloud.station.service.DepotInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.query.SortQuery;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 停车场动态信息
 */
@Service
public class StationStateRedis {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    DepotInfoService depotInfoService;


    public void save(DepotStationState depotStationState){
        if(depotStationState==null)return;
//TODO 要定时更新数据到数据库
        String key = ConstantsKey.STATION_STATE_PREFIX+depotStationState.getStationId()+"";

        //停车场信息
        DepotInfo depotInfo=null;


        boolean exists=redisTemplate.hasKey(key);
        if(exists){//如果缓存中存在
            DepotStationState temp = (DepotStationState) redisTemplate.opsForValue().get(key);
            if(temp.getDepotInfo()==null){//如果没有停车场的信息则从数据库中查询出来
                //查询
                depotInfo = (DepotInfo) depotInfoService.findByPrimaryKey(temp.getStationId());
            }else{
                depotInfo = temp.getDepotInfo();
            }
        }else{
            depotInfo = (DepotInfo) depotInfoService.findByPrimaryKey(depotStationState.getStationId());
        }
        depotStationState.setDepotInfo(depotInfo);

        redisTemplate.opsForValue().getAndSet(key,depotStationState);
    }

    /**
     * 存储车牌信息
     * @param carDTO
     */
    public void saveCarNumber(CarDTO carDTO){
        redisTemplate.opsForValue().getAndSet(carDTO.getNumber(),carDTO);
    }

    /**
     * 根据主键查询
     * @param key_
     * @return
     */
    public DepotStationState getByKey(Object key_){
        String key = ConstantsKey.STATION_STATE_PREFIX+key_;
        boolean exists=redisTemplate.hasKey(key);
        if(exists)
            return (DepotStationState) redisTemplate.opsForValue().get(key);
        else
            return null;
    }

    /**
     * 根据经纬度从缓存查询
     * @param position 位置信息
     * @param n 个数
     * @return
     */
    public List<DepotInfo> getByLatAndLon(Position position,Integer n){

        List<DepotInfo> list = new ArrayList<>();//容器

        List<DepotStationState> temp = new ArrayList<>();//临时容器


        Set<DepotStationState> s = redisTemplate.keys(ConstantsKey.STATION_STATE_PREFIX+"*");

        Iterator iterator = s.iterator();


        while (iterator.hasNext()){//获取所有内容到临时容器中
            String key = (String) iterator.next();
            DepotStationState depotStationState = (DepotStationState) redisTemplate.opsForValue().get(key);
            temp.add(depotStationState);
        }

        //TODO redis数据排序
        Collections.sort(temp, new Comparator<DepotStationState>() {
            @Override
            public int compare(DepotStationState o1, DepotStationState o2) {
                return o2.getLeft()-o1.getLeft();
            }
        });

        Integer i = 0;
        for(DepotStationState ds:temp){
            DepotInfo depotInfo = ds.getDepotInfo();
            if(depotInfo!=null){
                Double lat = depotInfo.getLatitude();
                Double lng = depotInfo.getLongitude();
                if(lat>=position.getLeftBottomLat() && lat<=position.getLeftTopLat() &&
                        lng>position.getLeftTopLng() && lng<=position.getRightTopLng()){
                    list.add(depotInfo);
                    i++;
                    if(i>=n)break;
                }
            }
        }

        return list;
    }

}
