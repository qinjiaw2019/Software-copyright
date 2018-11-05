package com.cloud.station.service.impl;

import com.cloud.station.base.impl.BaseServiceImpl;
import com.cloud.station.mapper.CarNumberBlacklistMapper;
import com.cloud.station.pojo.CarNumberBlacklist;
import com.cloud.station.service.CarNumberBlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carNumberBlackListService")
public class CarNumberBlackListServiceImpl extends BaseServiceImpl
        implements CarNumberBlackListService{

    @Autowired
    CarNumberBlacklistMapper carNumberBlacklistMapper;

    /**
     * 根据车牌查询
     *
     * @param carNumber
     * @return
     */
    @Override
    public List<CarNumberBlacklist> getByCarNumber(String carNumber,Integer page,Integer limit) {
        try {
            return carNumberBlacklistMapper.getByCarNumber(carNumber,(page-1)*limit,limit);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Long countFilterByCarNum(String carNum) {
        try {
            return carNumberBlacklistMapper.countByFilterCarNum(carNum);
        } catch (Exception e) {
            return 0L;
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
            return carNumberBlacklistMapper.update(entity);
        } catch (Exception e) {
            return 0;
        }
    }

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
            return carNumberBlacklistMapper.insert(entity);
        } catch (Exception e) {
            return 0;
        }
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
            return carNumberBlacklistMapper.deleteByPrimaryKey(pk);
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
            return carNumberBlacklistMapper.findByPrimaryKey(obj);
        } catch (Exception e) {
            return null;
        }
    }
}
