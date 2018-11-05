package com.cloud.station.mapper;


import com.cloud.station.base.BaseMapper;
import com.cloud.station.pojo.CarNumberUsing;
import com.cloud.station.pojo.UserInfo;

import java.util.List;


public interface CarNumberUsingMapper extends BaseMapper{

    /**
     * 根据车牌ID查询出车牌的使用情况
     * @param carNumberId 车牌ID
     * @param state  状态
     * @return
     * @throws Exception
     */
    public CarNumberUsing getByCarNumberId(Long carNumberId,Integer state)throws Exception;

}
