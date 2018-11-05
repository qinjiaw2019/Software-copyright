package com.cloud.station.service.impl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.station.base.impl.BaseServiceImpl;
import com.cloud.station.mapper.UserInfoMapper;
import com.cloud.station.pojo.UserInfo;
import com.cloud.station.service.UserInfoService;

import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl extends BaseServiceImpl  implements
		UserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	/**
	 * 插入一条用户信息记录
	 * @param userInfo 实体
	 * @return Integer
	 */
	@Override
	public Integer save(UserInfo userInfo) {
		try{
			Integer result = userInfoMapper.insert(userInfo);
			return result;
		}catch(Exception e){
			return 0;//插入用户信息出现异常，返回0.	
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
			return (UserInfo) userInfoMapper.findByPrimaryKey(obj);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据名称精确查找
	 *
	 * @param name 名称
	 * @return
	 * @
	 */
	@Override
	public List findByName(String name) {
		try {
			return userInfoMapper.findByName(name);
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
			return userInfoMapper.update(entity);
		} catch (Exception e) {
			return 0;
		}
	}

	/**************************************
	 * userInfoService
	 *************************************/
	/**
	 * 根据用户名查询密码
	 * @param account
	 * @return
	 */
	@Override
	public String getPasswordByAccount(String account) {
		try{
			String password = userInfoMapper.findPasswordByAccount(account);
			return password;
		}catch(Exception e){
			return null;
		}
	}

	/**
	 * 根据用户名查询对象
	 * @param account
	 * @return
	 */
	@Override
	public UserInfo getUserInfoByAccount(String account) {
		try{
			UserInfo userInfo = userInfoMapper.findByAccount(account);
			return userInfo;
		}catch(Exception e){
			return null;
		}
	}

	/**
	 * 分页查询
	 *
	 * @param skip  跳过记录数
	 * @param limit 每页记录查询条数
	 * @return 集合
	 * @
	 */
	@Override
	public List findByPage(Integer skip, Integer limit) {
		try {
			return  userInfoMapper.findByPage((skip-1)*limit,limit);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 统计总记录条数
	 *
	 * @return 总记录数
	 * @
	 */
	@Override
	public Long count() {
		try {
			return userInfoMapper.count();
		} catch (Exception e) {
			return 0L;
		}
	}
}
