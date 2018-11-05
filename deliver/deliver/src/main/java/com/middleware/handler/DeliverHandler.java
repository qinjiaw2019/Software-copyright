package com.middleware.handler;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.middleware.mapper.AddressMapper;
import com.middleware.mapper.AdminMapper;
import com.middleware.mapper.AdminUserMapper;
import com.middleware.mapper.DeliverHistoryMapper;
import com.middleware.mapper.DeliverMapper;
import com.middleware.mapper.DeliverReciveMapper;
import com.middleware.mapper.ExpressMapper;
import com.middleware.mapper.UserMapper;
import com.middleware.pojo.Address;
import com.middleware.pojo.Admin;
import com.middleware.pojo.AdminUser;
import com.middleware.pojo.Deliver;
import com.middleware.pojo.DeliverEx;
import com.middleware.pojo.DeliverHistory;
import com.middleware.pojo.DeliverRecive;
import com.middleware.pojo.Express;
import com.middleware.pojo.User;

@Controller
@RequestMapping("/deliver")
public class DeliverHandler {
	@Autowired
	DeliverMapper deliverMapper;
	
	@Autowired
	AddressMapper addressMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	AdminUserMapper adminUserMapper;
	
	@Autowired
	DeliverReciveMapper deliverReciveMapper;
	
	@Autowired
	DeliverHistoryMapper deliverHistoryMapper;
	
	@Autowired
	ExpressMapper expressMapper;
	/**
	 * 寄快递
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/send",method=RequestMethod.POST)
	@ResponseBody
	public Object register(Deliver deliver) {
		try {
			deliver.setState(0);
			deliver.setCode((new Date().getTime())+"");
			deliver.setCreateTime(new Date().getTime());
			return deliverMapper.insert(deliver);
		} catch (Exception e) {
			return -1;
		}	
	}
	/**
	 * 根据用户和状态查询快递
	 * @param deliver
	 * @return
	 */
	@RequestMapping(value="/lists",method=RequestMethod.GET)
	@ResponseBody
	public Object getByUserState(HttpServletRequest request) {
		String uid = request.getParameter("userId");
		String state_ = request.getParameter("state");
		if(uid==null || uid.equals("") ||
				state_ ==null || state_.equals(""))return -2;
		Integer id=null,state=null;
		System.out.println(uid+"--"+state_);
		try {
			id = Integer.valueOf(uid);
			state = Integer.valueOf(state_);
			return deliverMapper.getByUserState(id, state);
		} catch (Exception e) {
			return -1;
		}
	}
	/**
	 * 根据状态查询
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/lists/state",method=RequestMethod.GET)
	@ResponseBody
	public Object getByState(HttpServletRequest request) {
		String state_ = request.getParameter("state");
		if(state_ ==null || state_.equals(""))return -2;
		Integer state=null;
		try {
			state = Integer.valueOf(state_);
			return deliverMapper.getByState(state);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 根据用编号查询
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/code",method=RequestMethod.GET)
	@ResponseBody
	public Object getByCode(HttpServletRequest request) {
		String code = request.getParameter("code");
		if(code ==null || code.equals(""))return -2;
		//根据code查询出包裹信息
		DeliverEx deliver = deliverMapper.findByCode(code);
		
		//获得发货人信息
		User user = userMapper.findById(deliver.getUserId());
		deliver.setUser(user);
		
		//获得揽件表信息
		DeliverRecive deliverRecive = deliverReciveMapper.findByDeliverId(deliver.getId());
		//获得揽件人的信息
		AdminUser adminUser = adminUserMapper.findById(deliverRecive.getReciver_id());
		deliver.setAdminUser(adminUser);
		deliver.setCreateTime(deliverRecive.getCreate_time());//揽件时间
		
		//查询物流信息
		List list = deliverHistoryMapper.findByDeliverId(deliver.getId());
		//查询物流中的处理人详细信息
		for(int i = 0;i<list.size();i++) {
			DeliverHistory dh = (DeliverHistory) list.get(i);
			AdminUser adminUser2 = adminUserMapper.findById(dh.getReciver_id());
			dh.setAdminUser(adminUser2);
		}
		
		deliver.setHistory(list);
		
		//快递机构信息
		Express express = expressMapper.findById(deliver.getExpressId());
		deliver.setExpress(express);
		return deliver;
	}
}
