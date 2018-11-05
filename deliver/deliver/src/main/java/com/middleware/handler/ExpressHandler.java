package com.middleware.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.middleware.mapper.ExpressMapper;



@Controller
@RequestMapping("/express")
public class ExpressHandler {
	@Autowired
	ExpressMapper expressMapper;
	/**
	 * 获得所有的快递机构
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/lists",method=RequestMethod.GET)
	@ResponseBody
	public Object register(HttpServletRequest request) {
		String page_ = request.getParameter("page");
		String limit_ = request.getParameter("limit");
		Integer page = 1,limit=20;
		try {
			page = Integer.valueOf(page_);
			limit = Integer.valueOf(limit_);
		} catch (Exception e) {
			page = 1;
			limit = 20;
		}
		List list = expressMapper.getByPage((page-1)*limit, limit);
		return list.size()<=0?-1:list;
	}
}
