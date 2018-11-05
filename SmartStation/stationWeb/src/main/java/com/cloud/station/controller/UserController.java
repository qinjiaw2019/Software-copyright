package com.cloud.station.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.station.constant.Code;
import com.cloud.station.constant.ConstantsKey;
import com.cloud.station.constant.HttpCode;
import com.cloud.station.pojo.UserInfo;
import com.cloud.station.service.UserInfoService;
import com.cloud.station.utils.BeanUtils;
import com.cloud.station.utils.CommonUtils;
import com.cloud.station.utils.ParamValidUtils;
import com.cloud.station.utils.PasswordUtils;
import com.cloud.station.utils.result.JSONReturn;
import com.cloud.station.utils.result.JSONType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 用户登陆
	 * @param request
	 *            account 账号
	 *            password 密码
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONType login(HttpServletRequest request) {
		try {
			String username = (String) request.getSession().getAttribute(ConstantsKey.LOGIN_SESSION_TOKEN);
			if(username!=null)
				return JSONReturn.success();

			String account = request.getParameter("account");// 账号
			String password = request.getParameter("pwd");// 密码
			if(ParamValidUtils.isEmpty(account) || ParamValidUtils.isEmpty(password))
				return JSONReturn.error(HttpCode.PARAMETER_MISSING,"username and password are required");

			// 2.根据账户查询存储的密码
			String realPassword = userInfoService.getPasswordByAccount(account);
			UserInfo userInfo = userInfoService.getUserInfoByAccount(account);
			if(realPassword==null || !PasswordUtils.check(realPassword,password))
				return JSONReturn.error(Code.ERROR,"login failed");

			request.getSession().setAttribute(ConstantsKey.LOGIN_SESSION_TOKEN,account);
			return JSONReturn.success(userInfo.getId());
		} catch (Exception e) {
			return JSONReturn.error(HttpCode.LOGIN_FAILE, "login failed");
		}
	}

	/**
	 * 用户注册
	 * @param request
	 *            userInfo User 实体属性
	 * @return
	 */
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	@ResponseBody
	public JSONType register(HttpServletRequest request) {
		try {
			UserInfo userInfo = BeanUtils.toObject(request,UserInfo.class);

			/**
			 * 必要参数验证
			 * a.账号不能为空
			 * b.密码不能为空
			 */
			if(ParamValidUtils.isEmpty(userInfo.getAccount()) || ParamValidUtils.isEmpty(userInfo.getPwd()))
				return JSONReturn.error(HttpCode.PARAMETER_MISSING,"parameter missing");

			// 1.验证手机号格式
			if (!CommonUtils.isTel(userInfo.getAccount()))
				return JSONReturn.error(Code.ERROR, "register failed");

			String oldPwd = userInfo.getPwd();

			// 2.密码长度验证
			if (!PasswordUtils.checkLength(oldPwd))// 密码长度不符合要求
				return JSONReturn.error(HttpCode.PARAMETER_INVALIED,
						"password invalied");
			String newPwd = PasswordUtils.encrpty(oldPwd);// 密码加密处理

			userInfo.setPwd(newPwd);
			// id为自动增长
			userInfo.setId(null);
			userInfo.setCreateTime(new Date().getTime());
			// 金额精确到小数点后两位
			userInfo.setMoney(CommonUtils.keepDecimalDigits(userInfo.getMoney()));

			// 3.持久化数据
			List list=  userInfoService.findByName(userInfo.getAccount());
			if(list!=null && list.size()>0){//用户存在
				return JSONReturn.error(HttpCode.RESOURCE_EXSISTS,"already exsists");
			}
			Integer result = userInfoService.save(userInfo);

			return result > 0 ? JSONReturn.success() : JSONReturn.error(
					Code.ERROR, "register failed");

		} catch (Exception e) {
			e.printStackTrace();
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR, "unexpeted error");
		}
	}

	/**
	 * 获取用户基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public JSONType getUserInfo(HttpServletRequest request) {
		// 1.获取请求参数
//		= (String) request.getSession().getAttribute(ConstantsKey.LOGIN_SESSION_TOKEN);
		String uid = request.getParameter("uid");
		if(ParamValidUtils.isEmpty(uid)){
			return JSONReturn.error(HttpCode.PARAMETER_MISSING,"id is required");
		}

		// 2.更据用户名查询用户基本信息
		UserInfo userInfo = (UserInfo) userInfoService.findByPrimaryKey(Long.valueOf(uid));

		return userInfo != null ? JSONReturn.success(userInfo) : JSONReturn
				.error(HttpCode.NOT_EXSITS, "empty");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public JSONType getUserList(HttpServletRequest request) {
		try{
			String page_ = request.getParameter("page");
			String limit_ = request.getParameter("limit");
			String type_ = request.getParameter("type");

			Integer page = Integer.valueOf(page_);
			Integer limit = Integer.valueOf(limit_);
			Integer type = Integer.valueOf(type_);//管理员类型

			if(ParamValidUtils.isEmpty(page_))page=1;
			if(ParamValidUtils.isEmpty(limit_))limit=20;

			List list = null;
			Long total = 0L;
			list = userInfoService.findByPage(page, limit);
			total = userInfoService.count();

			Map result = new HashMap();
			result.put("data",list);
			result.put("total",total);
			result.put("pageIndex",page);
			result.put("pageSize",limit);

			return !list.isEmpty() ? JSONReturn.success(result):
					JSONReturn.error("empty");
		}catch (Exception e){
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR, "unexpeted error");
		}
	}

	/**
	 * 根据账号查询
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/get/account", method = RequestMethod.GET)
	@ResponseBody
	public JSONType getByAccount(HttpServletRequest request) {
		String account = request.getParameter("account");
		if(ParamValidUtils.isEmpty(account))
			return JSONReturn.error(HttpCode.PARAMETER_MISSING, "account required");

		UserInfo userInfo = userInfoService.getUserInfoByAccount(account);

		return userInfo!=null ? JSONReturn.success(userInfo) :
				JSONReturn.error(HttpCode.NOT_EXSITS,"empty");
	}
}