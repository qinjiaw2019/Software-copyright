package com.middleware.mapper;

import com.middleware.pojo.Address;
import com.middleware.pojo.Admin;

public interface AdminMapper {
	/**
	 * 根据用户名查询
	 * @param username 用户名
	 * @return
	 */
	public Admin findByName(String username);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Admin findById(Integer id);
	
	/**
	 * 添加一条记录
	 * @param user  用户实体
	 * @return 主键
	 */
	public Integer insert(Admin admin);
	
	/**
	 * 修改一条记录
	 * @param address
	 */
	public Integer update(Admin admin);
}
