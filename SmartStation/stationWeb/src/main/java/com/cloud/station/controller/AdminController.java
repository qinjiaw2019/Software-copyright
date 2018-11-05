package com.cloud.station.controller;

import com.cloud.station.constant.Code;
import com.cloud.station.constant.ConstantsKey;
import com.cloud.station.constant.HttpCode;
import com.cloud.station.pojo.AdminInfo;
import com.cloud.station.pojo.DepotAdminInfo;
import com.cloud.station.pojo.UserInfo;
import com.cloud.station.service.AdminInfoService;
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
import java.util.List;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {
	@Autowired
	private AdminInfoService adminInfoService;

	/**
	 * 管理员登陆
	 * @param request
	 *            account 账号
	 *            password 密码
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONType login(HttpServletRequest request) {
		try {
			String account = request.getParameter("account");// 账号
			String password = request.getParameter("pwd");// 密码
			if(ParamValidUtils.isEmpty(account) || ParamValidUtils.isEmpty(password))
				return JSONReturn.error(HttpCode.PARAMETER_MISSING,"username and password are required");

			// 2.根据账户查询存储的密码
			String realPassword = adminInfoService.getPasswordByAccount(account);
			AdminInfo adminInfo= adminInfoService.getDepotAdminInfoByAccount(account);
			if(realPassword==null || !PasswordUtils.check(realPassword,password))
				return JSONReturn.error(Code.ERROR,"login failed");

			request.getSession().setAttribute(ConstantsKey.LOGIN_SESSION_TOKEN,account);
			return JSONReturn.success(adminInfo.getId());
		} catch (Exception e) {
			return JSONReturn.error(HttpCode.LOGIN_FAILE, "login failed");
		}
	}

	/**
	 * 管理员添加
	 * @param request
	 *            userInfo User 实体属性
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JSONType register(HttpServletRequest request) {

			return JSONReturn.success();
	}

	/**
	 * 获取管理员基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public JSONType getUserInfo(HttpServletRequest request) {
		try{
			Integer uid = Integer.valueOf(request.getParameter("uid"));
			AdminInfo adminInfo = (AdminInfo) adminInfoService.findByPrimaryKey(uid);
			return JSONReturn.success(adminInfo);
		}catch (Exception e){
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
		}
	}
}