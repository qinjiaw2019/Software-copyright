package com.middleware.mapper;

import java.util.List;

import com.middleware.pojo.Address;
import com.middleware.pojo.DeliverRecive;


public interface DeliverReciveMapper {
	
	/**
	 * 根据包裹ID查询
	 * @param id
	 * @return
	 */
	public DeliverRecive findByDeliverId(Integer id);
}
