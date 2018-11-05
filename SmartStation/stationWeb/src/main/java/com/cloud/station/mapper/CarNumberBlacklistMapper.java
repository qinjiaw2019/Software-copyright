package com.cloud.station.mapper;

import com.cloud.station.base.BaseMapper;
import com.cloud.station.pojo.CarNumberBlacklist;

import java.util.List;

public interface CarNumberBlacklistMapper extends BaseMapper{

    /**
     * 根据车牌查询信息
     * @param carNum
     * @return
     * @throws Exception
     */
    public List<CarNumberBlacklist> getByCarNumber(String carNum,Integer skip,Integer limit) throws Exception;

    /**
     * 根据车牌统计
     * @param carNum
     * @return
     * @throws Exception
     */
    public Long countByFilterCarNum(String carNum)throws Exception;
}
