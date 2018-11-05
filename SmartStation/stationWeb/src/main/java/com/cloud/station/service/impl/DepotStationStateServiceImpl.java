package com.cloud.station.service.impl;


import com.cloud.station.base.impl.BaseServiceImpl;
import com.cloud.station.mapper.DepotStationStateMapper;
import com.cloud.station.pojo.DepotStationState;
import com.cloud.station.pojo.dto.MapAddressDTO;
import com.cloud.station.service.DepotStationStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

@Service("depotStationStateService")
public class DepotStationStateServiceImpl extends BaseServiceImpl implements DepotStationStateService {

    @Autowired
    DepotStationStateMapper depotStationStateMapper;
    /**
     * 增加一条记录
     *
     * @param entity 实体
     * @return 影响记录条数
     * @
     */
    @Override
    public Integer save(Object entity) {
        try {
           return depotStationStateMapper.insert(entity);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 增加或更新一条记录
     *
     * @param entity 实体
     * @return 影响记录条数
     * @
     */
    @Override
    public Integer saveOrUpdate(Object entity) {
        Integer rst = 0;
        try {
            DepotStationState depotStationState = (DepotStationState) depotStationStateMapper.find(entity);

            if(depotStationState!=null)
                rst =depotStationStateMapper.update(entity);
            else
                rst = depotStationStateMapper.insert(entity);
        } catch (Exception e) {
            rst = 0;
        }
        return rst;
    }

    /**
     * 根据地址查找停车场的状态信息包括停车场的基本信息
     *
     * @param mapAddressDTO
     * @return
     */
    @Override
    public List findByMapAddress(MapAddressDTO mapAddressDTO) {

        return null;
    }
}
