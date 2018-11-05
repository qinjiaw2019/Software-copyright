package com.cloud.station.service.impl;


import com.cloud.station.mapper.StationOrderMapper;
import com.cloud.station.pojo.DepotInfo;
import com.cloud.station.pojo.StationOrder;
import com.cloud.station.service.DepotInfoService;
import com.cloud.station.service.StationOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("stationOrderService")
public class StationOrderServiceImpl implements StationOrderService {

    @Autowired
    DepotInfoService depotInfoService;
    @Autowired
    StationOrderMapper stationOrderMapper;
    /**
     * 添加车牌
     *
     * @param carNumber
     * @return
     */
    @Override
    public Integer addByCarNum(Long stationId,String carNumber) {
        StationOrder stationOrder = new StationOrder();
        stationOrder.setStationId(stationId);
        stationOrder.setCarNum(carNumber);
        stationOrder.setCreateTime(new Date().getTime());
        stationOrder.setEndTime(0L);
        stationOrder.setState(StationOrder.UNDO);

        //如果存在
        StationOrder stationOrder_ = getByStationIdAndCarNuber(stationId,carNumber);
        if(stationOrder_!=null)return 0;

        try {
            return stationOrderMapper.insert(stationOrder);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 更新实体
     *
     * @param stationOrder
     * @return
     */
    @Override
    public Integer update(StationOrder stationOrder) {
        try {
            return stationOrderMapper.update(stationOrder);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 根据车牌查询
     *
     * @param carNum
     * @return
     */
    @Override
    public StationOrder getByCarNumber(String carNum) {
        StationOrder stationOrder = new StationOrder();
        stationOrder.setCarNum(carNum);

        try {
            return (StationOrder) stationOrderMapper.find(stationOrder).get(0);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 根据停车场ID和车牌查询
     *
     * @param stationId
     * @param carNum
     * @return
     */
    @Override
    public StationOrder getByStationIdAndCarNuber(Long stationId, String carNum) {
        try {
            return stationOrderMapper.findByStationIdAndCarNuber(stationId,carNum);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 查看历史信息
     *
     * @param carNum
     * @return
     */
    @Override
    public List<StationOrder> getHistory(String carNum) {
        StationOrder stationOrder = new StationOrder();
        stationOrder.setCarNum(carNum);
        try {
            return stationOrderMapper.find(stationOrder);
        } catch (Exception e) {
            return null;
        }
    }
}
