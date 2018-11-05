package com.cloud.station.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.station.base.impl.BaseServiceImpl;
import com.cloud.station.mapper.DepotAdminInfoMapper;
import com.cloud.station.pojo.AdminInfo;
import com.cloud.station.pojo.DepotAdminInfo;
import com.cloud.station.service.DepotAdminInfoService;

@Service("depotAdminInfoService")
public class DepotAdminInfoServiceImpl  extends BaseServiceImpl implements DepotAdminInfoService{
	
	@Autowired
	private DepotAdminInfoMapper depotAdminInfoMapper;

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
			Integer result = depotAdminInfoMapper.insert(entity);
			return result;
		} catch (Exception e) {
			return 0;//插入异常，返回0
		}
	}


	
	/**
	 * 根据主键删除一条记录
	 * @param id
	 * @return 影响记录条数
	 */
	public Integer delete(Integer id) {
		try {
			Integer result = depotAdminInfoMapper.deleteByPrimaryKey(id);
			return result;
		} catch (Exception e) {
			return 0;//删除异常，返回0
		}
	}
	
	/**
	 * 根据主键更新一条记录
	 * @param depotAdminInfo
	 * @return
	 */
	public Integer update(DepotAdminInfo depotAdminInfo) {
		try {
			Integer result = depotAdminInfoMapper.update(depotAdminInfo);
			return result;
		} catch (Exception e) {
			return 0;//更新异常，返回0
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
			return depotAdminInfoMapper.findByPrimaryKey(obj);
		} catch (Exception e) {
			return null;//查询异常，返回0
		}
	}


	 /**************************************
		 * depotAdminInfoService
		*************************************/
	 /**
	  * 根据账号查询密码
	  * @param account
	  * @return
	  */
		public String getPasswordByAccount(String account) {
			try {
				String password = depotAdminInfoMapper.findPasswordByAccount(account);
				return password;
			} catch (Exception e) {
				return null;
			}
		}

	/**
	 * 根据用户名查询用户的基本信息
	 *
	 * @param account
	 * @return
	 */
	@Override
	public DepotAdminInfo getDepotAdminInfoByAccount(String account) {
		try{
			return (DepotAdminInfo) (depotAdminInfoMapper.findByName(account)).get(0);
		}catch(Exception e){
			return null;
		}
	}
}
