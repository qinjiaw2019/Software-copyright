package com.middleware.mapper;

import java.util.List;

import com.middleware.pojo.Express;




public interface ExpressMapper {
	
	/**
	 * 获得所有的快递机构
	 * @param page 当前页
	 * @param limit 每页显示条数
	 * @return
	 */
	public List getByPage(Integer page,Integer limit);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public Express findById(Integer id);
}
