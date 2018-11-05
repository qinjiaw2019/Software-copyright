package com.middleware.mapper;

import com.middleware.pojo.Admin;
import com.middleware.pojo.User;

public interface UserMapper {
	/**
	 * 根据用户名查询
	 * @param username 用户名
	 * @return
	 */
	public User findUserByName(String username);
	
	/**
	 * 根据用户ID查询
	 * @param id
	 * @return
	 */
	public User findById(Integer id);
	
	/**
	 * 添加一条记录
	 * @param user  用户实体
	 * @return 主键
	 */
	public Integer insert(User user);
	
	/**
	 * 修改一条记录
	 * @param address
	 */
	public Integer update(User user);
}
