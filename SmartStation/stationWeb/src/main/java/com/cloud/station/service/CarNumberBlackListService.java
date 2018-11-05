package com.cloud.station.service;

import com.cloud.station.base.BaseService;
import com.cloud.station.pojo.CarNumberBlacklist;

import java.util.List;

public interface CarNumberBlackListService extends BaseService{

    /**
     * 根据车牌查询
     * @param carNumber
     * @return
     */
    public List<CarNumberBlacklist> getByCarNumber(String carNumber,Integer page,Integer limit);


    public Long countFilterByCarNum(String carNum);
}
