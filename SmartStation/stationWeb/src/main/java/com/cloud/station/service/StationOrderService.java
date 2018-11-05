package com.cloud.station.service;


import com.cloud.station.pojo.StationOrder;

import java.util.List;

public interface StationOrderService {

    /**
     * 添加订单
     * @param stationId
     * @param carNumber
     * @return
     */
    public Integer addByCarNum(Long stationId,String carNumber);

    /**
     * 更新实体
     * @param stationOrder
     * @return
     */
    public Integer update(StationOrder stationOrder);

    /**
     * 根据车牌查询
     * @param carNum
     * @return
     */
    public StationOrder getByCarNumber(String carNum);

    /**
     * 根据停车场ID和车牌查询
     * @param stationId
     * @param carNum
     * @return
     */
    public StationOrder getByStationIdAndCarNuber(Long stationId,String carNum);

    /**
     * 查看历史信息
     * @param carNum
     * @return
     */
    public List<StationOrder> getHistory(String carNum);
}
