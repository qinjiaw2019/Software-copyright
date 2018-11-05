package com.cloud.station.service;

import com.cloud.station.pojo.CarInfo;

import java.util.List;

public interface CarInfoService {

    /**
     * 根据实体查询
     * @return
     */
    public List get(CarInfo carInfo,Integer page,Integer limit);

    /**
     * 统计总记录数
     * @param carInfo
     * @return
     */
    public Long count(CarInfo carInfo);

    /**
     * 添加
     * @param carInfo
     * @return
     */
    public Integer add(CarInfo carInfo);
}
