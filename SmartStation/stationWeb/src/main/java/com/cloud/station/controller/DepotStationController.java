package com.cloud.station.controller;

import com.cloud.station.constant.Code;
import com.cloud.station.pojo.DepotStation;
import com.cloud.station.service.DepotStationService;
import com.cloud.station.utils.BeanUtils;
import com.cloud.station.utils.result.JSONReturn;
import com.cloud.station.utils.result.JSONType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @className: StationController
 * @data: 2018-03-06
 * @lastModify: 2018-03-06
 * @description: 停车场车位Controller
 * @version v1
 */
@Controller
@RequestMapping("/v1/station/parking")
public class DepotStationController {

	@Autowired
	private DepotStationService depotStationService;

	/**
	 * 添加停车场车位基本信息
	 * 
	 * @param request
	 *            depotStation 实体属性
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JSONType addDepotStation(HttpServletRequest request) {
		try {
			DepotStation depotStation = BeanUtils.toObject(request,DepotStation.class);
			// 1.持久化数据
			depotStation.setId(null);// 主键
			depotStation.setCreateTime(new Date().getTime());
			//TODO 要判断有没有重复的code
			Integer result = depotStationService.save(depotStation);
			return result > 0 ? JSONReturn.success() : JSONReturn.error(
					Code.ERROR, "Add failed");

		} catch (Exception e) {
			return JSONReturn.error(Code.ERROR, "failed");
		}
	}

	/**
	 * 删除停车场车位信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public JSONType delById(HttpServletRequest request) {
		try {
			// 1.获取请求参数
			Integer depotStationId = Integer.parseInt(request
					.getParameter("id"));// 停车场车位id

			// 2.更据主键删除停车场信息
			Integer result = depotStationService
					.deleteByPrimaryKey(depotStationId);
			return result > 0 ? JSONReturn.success() : JSONReturn.error(
					Code.ERROR, "Deleted failed");

		} catch (Exception e) {
			return JSONReturn.error(Code.ERROR, "failed");
		}
	}

	/**
	 * 根据主键修改停车场车位基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JSONType update(HttpServletRequest request, DepotStation depotStation) {
		try {
			// 1.获取请求参数
			Long depotStationId = Long.parseLong(request.getParameter("id"));// 主键id

			// 2.修改停车场车位信息
			depotStation.setCreateTime(new Date().getTime());
			
			Integer result = depotStationService.update(depotStation);
			return result > 0 ? JSONReturn.success() : JSONReturn.error(
					Code.ERROR, "failed");

		} catch (Exception e) {
			return JSONReturn.error(Code.ERROR, "failed");
		}
	}

	/**
	 * 根据主键获取停车场车位信息 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public JSONType select(HttpServletRequest request) {
		try {
			// 1.获取请求参数
			Integer depotStationId = Integer.parseInt(request
					.getParameter("id"));// 停车场主键id

			// 2.根据主键获取停车场车位信息
			DepotStation depotStation = (DepotStation) depotStationService
					.findByPrimaryKey(depotStationId);
			return depotStation != null ? JSONReturn.success(depotStation) : JSONReturn
					.error(Code.ERROR, "not exist.");

		} catch (Exception e) {
			return JSONReturn.error(Code.ERROR, "failed");
		}
	}
}
