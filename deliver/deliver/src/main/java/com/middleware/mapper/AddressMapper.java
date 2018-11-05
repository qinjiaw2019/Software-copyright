package com.middleware.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.middleware.pojo.Address;
import com.middleware.pojo.Admin;
import com.middleware.pojo.User;

public interface AddressMapper {
	
	/**
	 * 查询用户的所有地址
	 * @param userId 用户ID
	 * @param page 当前页
	 * @param limit 每页显示条数
	 * @return
	 */
	public List getByPage(Integer userId,Integer page,Integer limit);
	
	/**
	 * 修改一条记录
	 * @param address
	 */
	public Integer update(Address address);
	
	/**
	 * 删除一条地址
	 * @param id
	 * @return
	 */
	public Integer delete(Address address);
	/**
	 * 添加一条记录
	 * @param user  用户实体
	 * @return 主键
	 */
	public Integer insert(Address address);
}
