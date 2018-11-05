package com.middleware.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.middleware.mapper.AddressMapper;
import com.middleware.mapper.AdminMapper;
import com.middleware.mapper.AdminUserMapper;
import com.middleware.pojo.Address;
import com.middleware.pojo.Admin;
import com.middleware.pojo.AdminUser;


@Controller
@RequestMapping("/address")
public class AddressHandler {
	@Autowired
	AddressMapper addressMapper;
	/**
	 * 获取用户的所有联系地址
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/lists",method=RequestMethod.GET)
	@ResponseBody
	public Object register(HttpServletRequest request) {
		String uid = request.getParameter("uid");//用户ID
		String limit_ = request.getParameter("limit");
		String page_ = request.getParameter("page");
		Integer page=1,limit = 20,id=-1;
		if(uid==null )
			return -1;
		if(limit_==null || limit_.equals("")) limit_="20";
		if(page_==null || page_.equals("")) page_="1";
		try {
			id = Integer.valueOf(uid);
			limit = Integer.valueOf(limit_);
			page = Integer.valueOf(page_);
		} catch (Exception e) {
			id = -1;
			limit = 1;
			page = 20;
		}
		List list = addressMapper.getByPage(id, (page-1)*limit, limit);
		return list.size()<=0?-1:list;
	}
	
	/**
	 * 添加一条记录
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Object add(Address address) {
		if(address!=null) {
			addressMapper.insert(address);
			return 1;
		}
		return -1;
	}
	
	/**
	 * 修改一条地址
	 * @param address
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Object edit(Address address) {
		if(address!=null) {
			return addressMapper.update(address);
		}
		return -1;
	}
	
	/**
	 * 删除一条地址
	 * @param address
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	@ResponseBody
	public Object delete(HttpServletRequest request) {
		String id_ = request.getParameter("id");
		String uid = request.getParameter("user_id");
		
		Integer id=null,userId = null;
		try {
			id = Integer.valueOf(id_);
			userId = Integer.valueOf(uid);
		} catch (Exception e) {
			return -1;
		}
		Address address = new Address();
		address.setId(id);
		address.setUser_id(userId);
		Integer state = addressMapper.delete(address);
		return state>0?state:-1;
	}
}
