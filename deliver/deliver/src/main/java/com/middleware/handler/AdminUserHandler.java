package com.middleware.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.middleware.mapper.AdminUserMapper;
import com.middleware.mapper.DeliverMapper;
import com.middleware.pojo.AdminUser;
import com.middleware.pojo.Deliver;

@Controller
@RequestMapping("/admin/user")
public class AdminUserHandler {
	@Autowired
	AdminUserMapper adminUserMapper; 
	
	@Autowired
	DeliverMapper deliverMapper;
	/**
	 * 用户注册
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	@ResponseBody
	public Object register(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String id_card = request.getParameter("idCard");
		String name = request.getParameter("name");
		String tell = request.getParameter("tell");
		String state = request.getParameter("state");
		
		if(username==null || username.equals("") ||
		   password==null || password.equals("") ||
		   id_card==null || id_card.equals(""))
			return -1;
		AdminUser adminUser = adminUserMapper.findByName(username);
		if(adminUser!=null) return -2;
		
		AdminUser adminUser_ = new AdminUser();
		adminUser_.setUsername(username);
		adminUser_.setPassword(password);
		adminUser_.setIdCard(id_card);
		adminUser_.setName(name);
		adminUser_.setTell(tell);
		adminUser_.setState(Integer.valueOf(state));
		
		Integer id = adminUserMapper.insert(adminUser_);
		
		return id>0?id:-1;
	}
	
	/**
	 * 修改用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Object edit(AdminUser adminUser) {
		if(adminUser!=null) {
			return adminUserMapper.update(adminUser);
		}
		return -1;
	}
	
	/**
	 * 快递员揽件
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deliver/get",method=RequestMethod.GET)
	@ResponseBody
	public Object getDeliver(HttpServletRequest request) {
		String uid = request.getParameter("userId");
		String deliver_id = request.getParameter("deliver_id");
		Integer id=null,deliverId=null;
		try {
			id = Integer.valueOf(uid);
			deliverId = Integer.valueOf(deliver_id);
			
			AdminUser adminUser = adminUserMapper.findById(id);
			if(adminUser==null) return -1;//如果用户不存在
			if(adminUser.getState()!=1) return -2;//如果未通过审核
			
			Deliver deliver = deliverMapper.findById(deliverId);
			if(deliver.getState()!=0) return -3;//如果包裹不处于可揽状态
			
			//处理揽件逻辑
			deliver.setState(1);//修改状态
			deliverMapper.update(deliver);//更新包裹的状态
			//TODO 其他操作
			
			return 1;
		} catch (Exception e) {
			return -1;
		}
		
	}
	
}
