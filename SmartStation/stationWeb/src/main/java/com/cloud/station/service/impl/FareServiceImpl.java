package com.cloud.station.service.impl;


import com.cloud.station.base.impl.BaseServiceImpl;
import com.cloud.station.fare.api.ChargeApi;
import com.cloud.station.fare.entity.Rule;
import com.cloud.station.mapper.FareRuleMapper;
import com.cloud.station.pojo.FareRule;
import com.cloud.station.service.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fareService")
public class FareServiceImpl extends BaseServiceImpl implements FareService{

    @Autowired
    FareRuleMapper fareRuleMapper;

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
            return fareRuleMapper.insert(entity);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 查询停车场当前正在使用的规则
     *
     * @param stationId
     * @return
     */
    @Override
    public FareRule getUsedByStationId(Long stationId) {
        try {
            return fareRuleMapper.getUsedByStationId(stationId);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据停车场ID查询所有
     *
     * @param stationId
     * @return
     */
    @Override
    public List<FareRule> getAll(Long stationId) {
        try {
            return fareRuleMapper.getAll(stationId);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 停车场计费
     *
     * @param rule
     * @return
     */
    @Override
    public float calc(Rule rule) {
        return (new ChargeApi(rule)).calc();
    }

    /**
     * 根据主键删除一条记录
     *
     * @param pk 主键
     * @return 影响记录条数
     * @
     */
    @Override
    public Integer deleteByPrimaryKey(Object pk) {
        try {
            return fareRuleMapper.deleteByPrimaryKey(pk);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 更具主键查询一条记录
     *
     * @param obj 主键
     * @return 对象实体
     * @
     */
    @Override
    public Object findByPrimaryKey(Object obj) {
        try {
            return fareRuleMapper.findByPrimaryKey(obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 更新一条记录
     *
     * @param entity 实体
     * @return 影响记录条数
     * @
     */
    @Override
    public Integer update(Object entity) {
        try {
            return fareRuleMapper.update(entity);
        } catch (Exception e) {
            return 0;
        }
    }
}
