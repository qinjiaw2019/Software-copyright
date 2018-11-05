package com.middleware.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/test")
public class test{
	//增加RESTFULL 版本控制//produces={"text/html;charset=UTF-8;","application/json;"}
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public String test(HttpServletRequest request) {
		System.out.println("OK");
		return "OK";
	}
	@RequestMapping(value="/test2",method=RequestMethod.GET)
	@ResponseBody
	public String test2(String id) {
		System.out.println(id);
		return id;
		
	}
}
