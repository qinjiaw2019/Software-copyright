package com.cloud.station.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.station.base.impl.BaseServiceImpl;
import com.cloud.station.mapper.DepotStationMapper;
import com.cloud.station.pojo.DepotStation;
import com.cloud.station.service.DepotStationService;
import com.cloud.station.service.DepotStationService;

@Service("depotStationService")
public class DepotStationServiceImpl extends BaseServiceImpl implements
		DepotStationService {
	
	@Autowired
	private DepotStationMapper depotStationMapper;


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
			return depotStationMapper.insert(entity);
		} catch (Exception e) {
			return 0;
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
			Integer result = depotStationMapper.update(entity);
			return result;
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
			Integer result = depotStationMapper.deleteByPrimaryKey(pk);
			return result;
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

			return depotStationMapper.findByPrimaryKey(obj);
		} catch (Exception e) {
			return null;
		}
	}
}
