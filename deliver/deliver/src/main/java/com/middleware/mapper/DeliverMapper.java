package com.middleware.mapper;

import java.util.List;

import com.middleware.pojo.Address;
import com.middleware.pojo.Deliver;
import com.middleware.pojo.DeliverEx;

public interface DeliverMapper {
	
	/**
	 * 根据查询指定用户的某种状态的快递
	 * @param deliver
	 * @return
	 */
	public List getByUserState(Integer userId,Integer state);
	
	/**
	 * 根据查询指定用户的某种状态的快递
	 * @param deliver
	 * @return
	 */
	public List getByState(Integer state);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public Deliver findById(Integer id);
	
	/**
	 * 根据编号查询
	 * @param code
	 * @return
	 */
	public DeliverEx findByCode(String code);
	
	/**
	 * 修改一条记录
	 * @param address
	 */
	public Integer update(Deliver deliver);
	
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
	public Integer insert(Deliver deliver);
}
