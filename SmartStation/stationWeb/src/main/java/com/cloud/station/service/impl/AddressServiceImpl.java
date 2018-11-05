package com.cloud.station.service.impl;

import com.cloud.station.base.impl.BaseServiceImpl;
import com.cloud.station.mapper.AddressMapper;
import com.cloud.station.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressService")
public class AddressServiceImpl extends BaseServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;
    /**
     * 查询
     *
     * @param entity 实体
     * @return List    集合
     * @
     */
    @Override
    public List find(Object entity) {
        try {
            return addressMapper.find(entity);
        } catch (Exception e) {
            return null;
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
            return addressMapper.insert(entity);
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
            return addressMapper.findByPrimaryKey(obj);
        } catch (Exception e) {
            return null;
        }
    }
}
