package com.cloud.station.service;

/**
 * @className:     PayService
 * @data:          2018-03-10
 * @lastModify:    2018-03-10
 * @description:   账号充值Service
 */
public interface PayService {

    /**
     * 根据车牌扣费
     * @param carNumber 车牌
     * @param endTime  结束时间
     * @return
     */
    public float pay(String carNumber,Long endTime);

    /**
     * 根据停车和停车场ID付款
     * @param stationId
     * @param carNum
     * @return 返回总消费金额
     */
    public float pay(Long stationId,String carNum);
}
