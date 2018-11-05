package com.middleware.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.middleware.mapper.AdminMapper;
import com.middleware.mapper.AdminUserMapper;
import com.middleware.mapper.UserMapper;
import com.middleware.pojo.Admin;
import com.middleware.pojo.AdminUser;
import com.middleware.pojo.User;

@Controller
@RequestMapping("/user")
public class UserHandler {
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	AdminUserMapper adminUserMapper;
	/**
	 * 登陆
	 * @param id
	 * @return 用户ID
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Object login(HttpServletRequest request) {
		
		String type = request.getParameter("type");//登陆用户类型 0:普通用户  2:快递员登陆, 1:后台管理员登陆
		String username = request.getParameter("username");//用户名
		String password = request.getParameter("password");//密码
		if(type==null || type.equals("")) type = "0";//默认是普通用户
		
		//用户名和密码不能为空
		if(username==null || username.equals("") ||
		   password==null || password.equals("")) return -1;
		
		if(type.equals("0")) {//普通用户登陆
			User user = userMapper.findUserByName(username);
			if(user!=null && user.getPassword().equals(password)) {//验证密码
				request.getSession().setAttribute("uid", user.getId());
				return user.getId();
			}
		}else if(type.equals("1")) {
			Admin admin = adminMapper.findByName(username);
			if(admin!=null && admin.getPassword().equals(password)) {//验证密码
				request.getSession().setAttribute("uid", admin.getId());
				return admin.getId();
			}
		}else if(type.equals("2")) {
			AdminUser adminUser = adminUserMapper.findByName(username);
			if(adminUser!=null && adminUser.getPassword().equals(password)) {//验证密码
				request.getSession().setAttribute("uid", adminUser.getId());
				return adminUser.getId();
			}
		}
	
		return -1;
	}
	
	/**
	 * 获取用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/info",method=RequestMethod.GET)
	@ResponseBody
	public Object getInfo(HttpServletRequest request) {
		String uid = request.getParameter("uid");//获取用户的id
		String type = request.getParameter("type");//用户类别
		Integer id = 0;
		if(type==null || type.equals("")) type = "0";//默认是普通用户
		
		//用户id为空
		if(uid==null || uid.equals("")) return -1;
		
		try {
			id = Integer.valueOf(uid);
		} catch (Exception e) {
			id = 0;//如果id转成错误则默认为0
		}
		
		if(type.equals("0")) {//获取普通用户信息
			User user = userMapper.findById(id);
			return user==null?-1:user;
		}else if(type.equals("1")) {//获取管理员信息
			Admin admin = adminMapper.findById(id);
			return admin==null?-1:admin;
		}else if(type.equals("2")) {//获取快递员信息
			AdminUser adminUser = adminUserMapper.findById(id);
			return adminUser==null?-1:adminUser;
		}
		
		return -1;
	}
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
		String tell = request.getParameter("tell");
		String name = request.getParameter("name");
		
		if(username==null || username.equals("") ||
		   password==null || password.equals("") ||
		   tell==null || tell.equals(""))
			return -1;
		
		//如果用户已经存在则报错
		User user_ = userMapper.findUserByName(username);
		if(user_!=null) return -2;
		
		//封装成实体类
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setTell(tell);
		user.setMoney(0.0f);
		user.setIntegration(0);
		user.setName(name);
		
		Integer id = userMapper.insert(user);
		return id>0?id:-1;
	}
	/**
	 * 修改用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Object edit(User user) {
		if(user!=null) {
			User user_ = userMapper.findById(user.getId());
			user.setMoney(user_.getMoney());
			user.setIntegration(user_.getIntegration());
			return userMapper.update(user);
		}
		return -1;
	}
	
	
}
