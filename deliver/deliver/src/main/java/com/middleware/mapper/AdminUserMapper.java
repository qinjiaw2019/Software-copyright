package com.middleware.mapper;

import com.middleware.pojo.Admin;
import com.middleware.pojo.AdminUser;
import com.middleware.pojo.User;

public interface AdminUserMapper {
	/**
	 * 根据用户名查询
	 * @param username 用户名
	 * @return
	 */
	public AdminUser findByName(String username);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public AdminUser findById(Integer id);
	
	/**
	 * 添加一条记录
	 * @param user  用户实体
	 * @return 主键
	 */
	public Integer insert(AdminUser adminUser);
	
	/**
	 * 修改一条记录
	 * @param address
	 */
	public Integer update(AdminUser adminUser);
}
