package com.cloud.station.service;

import com.cloud.station.pojo.CarInfo;

/**
 * 收费标准Service
 */
public interface DepotFareStandardService {

    /**
     * 根据车信息计费
     * @param carInfo
     * @return
     */
    public Float calculateFare(CarInfo carInfo);
}
