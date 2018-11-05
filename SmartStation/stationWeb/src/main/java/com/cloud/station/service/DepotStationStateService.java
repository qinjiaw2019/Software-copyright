package com.cloud.station.service;


import com.cloud.station.base.BaseService;
import com.cloud.station.pojo.dto.MapAddressDTO;
import java.util.List;

public interface DepotStationStateService extends BaseService{

    /**
     * 根据地址查找停车场的状态信息包括停车场的基本信息
     * @param mapAddressDTO
     * @return
     */
    public List findByMapAddress(MapAddressDTO mapAddressDTO);
}
