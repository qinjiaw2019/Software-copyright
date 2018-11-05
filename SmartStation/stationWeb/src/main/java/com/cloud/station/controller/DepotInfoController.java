package com.cloud.station.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.station.algorithm.Distance;
import com.cloud.station.constant.Code;
import com.cloud.station.constant.HttpCode;
import com.cloud.station.pojo.Address;
import com.cloud.station.pojo.DepotInfo;
import com.cloud.station.pojo.dto.Position;
import com.cloud.station.service.AddressService;
import com.cloud.station.service.DepotInfoService;
import com.cloud.station.service.redis.StationStateRedis;
import com.cloud.station.utils.BeanUtils;
import com.cloud.station.utils.ParamValidUtils;
import com.cloud.station.utils.result.JSONReturn;
import com.cloud.station.utils.result.JSONType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v1/station")
public class DepotInfoController {

	@Autowired
	private DepotInfoService depotInfoService;
	@Autowired
	AddressService addressService;
	@Autowired
	StationStateRedis stationStateRedis;

	/**
	 * 添加停车场信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JSONType save(HttpServletRequest request) {
		try{
			DepotInfo depotInfo = BeanUtils.toObject(request,DepotInfo.class);
			Address address = BeanUtils.toObject(request,Address.class);
			Integer stationNum = depotInfo.getStationNum();// 车位总数

			//车位<0时
			if (stationNum==null || stationNum<0){
				depotInfo.setStationNum(0);
			}

			//如果名称为空或者用户ID为空
			if(ParamValidUtils.isEmpty(depotInfo.getName()) ||
					depotInfo.getUserId()==null)
				return JSONReturn.error(HttpCode.PARAMETER_MISSING,"parameter missing");


			depotInfo.setId(null);
			depotInfo.setCreateTime(new Date().getTime());
			address.setCreateTime(new Date().getTime());



			// 3.持久化数据
			//保存地址
			List<Address> addressList = addressService.find(address);
			if(addressList==null || addressList.isEmpty()){
				addressService.save(address);
				addressList = addressService.find(address);
			}

			Long id = Long.valueOf(addressList.get(0).getId());
			if(id!=null)
				depotInfo.setAddressId(id);

//			List list = depotInfoService.find(depotInfo);
//			if(list!=null && list.size()>0){//数据存在
//				return JSONReturn.error(HttpCode.RESOURCE_EXSISTS,"failed");
//			}

			Integer result = depotInfoService.save(depotInfo);

			return result > 0 ? JSONReturn.success() : JSONReturn.error(Code.ERROR,
					"add failed");
		}catch (Exception e){
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
		}
	}

	/**
	 * 根据主键id修改停车场基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JSONType update(HttpServletRequest request) {
		try{
			DepotInfo depotInfo = BeanUtils.toObject(request,DepotInfo.class);
			if(depotInfo.getId()==null ||
					depotInfo.getUserId()==null ||
					depotInfo.getAddressId()==null ||
					depotInfo.getStationNum()<0)
				return JSONReturn.error(HttpCode.PARAMETER_INVALIED,"paramter invalied");

			Address address = (Address) addressService.findByPrimaryKey(depotInfo.getAddressId());
			if(address==null)
				return JSONReturn.error(HttpCode.NOT_EXSITS,"address is not exsist");

			// 3.修改停车场信息
			DepotInfo depotInfo_ = (DepotInfo) depotInfoService.findByPrimaryKey(depotInfo.getId());
			if (depotInfo==null) return JSONReturn.error(HttpCode.RESULT_EMPTY,"empty");

			Integer result = depotInfoService.update(depotInfo);
			return result > 0 ? JSONReturn.success() : JSONReturn.error(Code.ERROR,
					"Update failed");
		}catch (Exception e){
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
		}
	}

	/**
	 * 根据主键获取停车场信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public JSONType select(HttpServletRequest request) {
		try {
			// 1.获取请求参数
			Integer depotInfoId = Integer.parseInt(request.getParameter("id"));// 停车场主键id

			// 2.根据主键获取停车场信息
			DepotInfo depotInfo = (DepotInfo) depotInfoService
					.findByPrimaryKey(depotInfoId);
			
			return depotInfo != null ? JSONReturn.success(depotInfo) : JSONReturn.error(
					Code.ERROR, "empty");

		} catch (Exception e) {
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
		}
	}

	/**
	 * 分页查询停车场信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list/address", method = RequestMethod.GET)
	@ResponseBody
	public JSONType getByPage(HttpServletRequest request) {
		try{
			Integer page = Integer.valueOf(request.getParameter("page"));//当前页
			Integer limit = Integer.valueOf(request.getParameter("limit"));//每页条数


			page = page == null ? 1 : page;//默认1
			limit = limit == null ? 20 : limit;//默认为20
			List list = depotInfoService.findByPage(page,limit);
			Long total = depotInfoService.count();//总条数
			Map result = new HashMap();
			result.put("data",list);
			result.put("total",total);
			result.put("pageIndex",page);
			result.put("pageSize",limit);

			return list!=null ? JSONReturn.success(result) :
					JSONReturn.empty("empty");

		}catch (Exception e){
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpected error");
		}

	}


	/**
	 * 根据经纬度查询指定范围的停车场信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/get/position", method = RequestMethod.GET)
	@ResponseBody
	public JSONType getByPosition(HttpServletRequest request) {
		try{
			Double lat = Double.valueOf(request.getParameter("lat"));//精度
			Double lng = Double.valueOf(request.getParameter("lng"));//纬度
			Double len = Double.valueOf(request.getParameter("len"));//范围
			Integer page = Integer.valueOf(request.getParameter("page"));
			Integer limit = Integer.valueOf(request.getParameter("limit"));
			Integer step = Integer.valueOf(request.getParameter("step"));//TODO 暂未使用步进发


			if(lat<=0 || lng<=0 || len<=0) return JSONReturn.error(HttpCode.PARAMETER_MISSING,"parameter missing");

			Position position = Distance.calcPosition(lat,lng,len);
			List list = depotInfoService.getByLatAndLon(position,page,limit);
			if(list.isEmpty() || list.size()<limit){
				List list_ = stationStateRedis.getByLatAndLon(position,limit-list.size());
				list.addAll(list_);
			}

			return JSONReturn.success(list);
		}catch (Exception e){
			e.printStackTrace();
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
		}
	}

	/**
	 * TODO 停车场预约
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	@ResponseBody
	public JSONType orderStation(HttpServletRequest request) {
		try{
			Long userId = Long.valueOf(request.getParameter("uid"));//用户ID
			Long stationId = Long.valueOf(request.getParameter("sid"));//停车场ID
			//1.查询停车场信息  如果存在
			//2.查询用户  如果存在
			//3.用户的余额不能少于停车场的费用
			//4.余额 不足调用支付宝接口充值
			return JSONReturn.success();
		}catch (Exception e){
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
		}

	}

	/**
	 * 根据停车场管理员的id获取所有的停车场
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public JSONType getAll(HttpServletRequest request) {
		try{
			String uid = request.getParameter("uid");
			if(ParamValidUtils.isEmpty(uid))
				return JSONReturn.error(HttpCode.PARAMETER_MISSING,"uid is required");

			DepotInfo depotInfo = new DepotInfo();
			depotInfo.setUserId(Long.valueOf(uid));
			List list = depotInfoService.find(depotInfo);
			return JSONReturn.success(list);
		}catch (Exception e){
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
		}
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public JSONType delete(HttpServletRequest request) {
		try{
			String id = request.getParameter("id");
			if(ParamValidUtils.isEmpty(id))
				return JSONReturn.error(HttpCode.PARAMETER_MISSING,"id is required");

			Integer rst = depotInfoService.deleteByPrimaryKey(Long.valueOf(id));
			return rst>0 ? JSONReturn.success() :
					JSONReturn.error("failed");
		}catch (Exception e){
			return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
		}
	}
}
