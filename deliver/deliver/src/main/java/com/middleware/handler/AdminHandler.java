package com.middleware.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.middleware.mapper.AdminMapper;
import com.middleware.mapper.AdminUserMapper;
import com.middleware.pojo.Admin;
import com.middleware.pojo.AdminUser;


@Controller
@RequestMapping("/admin")
public class AdminHandler {
	@Autowired
	AdminMapper adminMapper; 
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
		
		if(username==null || username.equals("") ||
		   password==null || password.equals(""))
			return -1;
		Admin admin_ = adminMapper.findByName(username);
		if(admin_!=null) return -2;
		
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		
		Integer id = adminMapper.insert(admin);
	
		return id>0?id:-1;
	}
	/**
	 * 修改用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Object edit(Admin admin) {
		if(admin!=null) {
			return adminMapper.update(admin);
		}
		return -1;
	}
}
