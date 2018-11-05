package com.cloud.station.mapper;

import com.cloud.station.base.BaseMapper;
import com.cloud.station.pojo.FareRule;

import java.util.List;

public interface FareRuleMapper extends BaseMapper{

    /**
     * 查询停车场下的所有规则
     * @param stationId
     * @return
     */
    public List<FareRule> getAll(Long stationId) throws Exception;

    /**
     * 查询停车场正在使用的规则信息
     * @param stationId
     * @return
     * @throws Exception
     */
    public FareRule getUsedByStationId(Long stationId) throws Exception;
}
