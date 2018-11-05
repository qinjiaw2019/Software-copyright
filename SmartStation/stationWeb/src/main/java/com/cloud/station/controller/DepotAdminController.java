package com.cloud.station.controller;

import com.cloud.station.constant.Code;
import com.cloud.station.constant.ConstantsKey;
import com.cloud.station.constant.HttpCode;
import com.cloud.station.pojo.AdminInfo;
import com.cloud.station.pojo.DepotAdminInfo;
import com.cloud.station.pojo.UserInfo;
import com.cloud.station.service.DepotAdminInfoService;
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
@RequestMapping("/v1/depot/admin")
public class DepotAdminController {
	@Autowired
	private DepotAdminInfoService depotAdminInfoService;

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
			String realPassword = depotAdminInfoService.getPasswordByAccount(account);
			DepotAdminInfo depotAdminInfo= depotAdminInfoService.getDepotAdminInfoByAccount(account);
			if(realPassword==null || !PasswordUtils.check(realPassword,password))
				return JSONReturn.error(Code.ERROR,"login failed");

			request.getSession().setAttribute(ConstantsKey.LOGIN_SESSION_TOKEN,account);
			return JSONReturn.success(depotAdminInfo.getId());
		} catch (Exception e) {
			return JSONReturn.error(HttpCode.LOGIN_FAILE, "login failed");
		}

	}

	/**
	 * 管理员注册
	 * @param request
	 *            userInfo User 实体属性
	 * @return
	 */
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	@ResponseBody
	public JSONType register(HttpServletRequest request) {
		try {
			DepotAdminInfo depotAdminInfo = BeanUtils.toObject(request,DepotAdminInfo.class);

			/**
			 * 必要参数验证
			 * a.账号不能为空
			 * b.密码不能为空
			 */
			if(ParamValidUtils.isEmpty(depotAdminInfo.getAccount()) || ParamValidUtils.isEmpty(depotAdminInfo.getPwd()))
				return JSONReturn.error(HttpCode.PARAMETER_MISSING,"parameter missing");

			String newPwd = PasswordUtils.encrpty(depotAdminInfo.getPwd());// 密码加密处理

			depotAdminInfo.setPwd(newPwd);
			// id为自动增长
			depotAdminInfo.setId(null);
			depotAdminInfo.setCreateTime(new Date().getTime());


			// 3.持久化数据
			List list=  depotAdminInfoService.findByName(depotAdminInfo.getAccount());
			if(list!=null && list.size()>0){//用户存在
				return JSONReturn.error(HttpCode.RESOURCE_EXSISTS,"already exsists");
			}
			Integer result = depotAdminInfoService.save(depotAdminInfo);

			return result > 0 ? JSONReturn.success() : JSONReturn.error(
					Code.ERROR, "register failed");

		} catch (Exception e) {
			e.printStackTrace();
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR, "unexpeted error");
		}
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
			DepotAdminInfo depotAdminInfo = (DepotAdminInfo) depotAdminInfoService.findByPrimaryKey(uid);
			return JSONReturn.success(depotAdminInfo);
		}catch (Exception e){
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
		}
	}
}