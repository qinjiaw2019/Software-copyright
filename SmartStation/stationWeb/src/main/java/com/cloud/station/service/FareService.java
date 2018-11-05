package com.cloud.station.service;


import com.cloud.station.base.BaseService;
import com.cloud.station.fare.entity.Rule;
import com.cloud.station.pojo.FareRule;

import java.util.List;

public interface FareService extends BaseService{

    /**
     * 查询停车场当前正在使用的规则
     * @param stationId
     * @return
     */
    public FareRule getUsedByStationId(Long stationId);

    /**
     * 根据停车场ID查询所有
     * @param stationId
     * @return
     */
    public List<FareRule> getAll(Long stationId);

    /**
     * 停车场计费
     * @param rule
     * @return
     */
    public float calc(Rule rule);
}
