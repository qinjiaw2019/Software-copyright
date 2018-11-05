package com.cloud.station.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.station.conf.ConfigurationManager;
import com.cloud.station.constant.Code;
import com.cloud.station.constant.HttpCode;
import com.cloud.station.pojo.CarInfo;
import com.cloud.station.service.CarInfoService;
import com.cloud.station.service.StationOrderService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className:     CarInfoController
 * @data:          2018-03-06
 * @lastModify:    2018-03-06
 * @description:   APP Controller
 * @version         v1
 */
@Controller
@RequestMapping("/v1/carinfo")
public class CarInfoController {

    @Autowired
    CarInfoService carInfoService;

    @Autowired
    StationOrderService stationOrderService;

    /**
     * 查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public JSONType getByNum(HttpServletRequest request){
        try{
            CarInfo carInfo = new CarInfo();
            String carNumber =request.getParameter("carNumber");
            String carNumberType =request.getParameter("carNumberType");
            String carType =request.getParameter("carType");
            String carXH =request.getParameter("carXH");
            String carYear =request.getParameter("carYear");
            String carColor =request.getParameter("carColor");
            String code =request.getParameter("code");

            if(!ParamValidUtils.isEmpty(carNumber))carInfo.setCarNumber(carNumber);
            if(!ParamValidUtils.isEmpty(carNumberType))carInfo.setCarNumberType(carNumberType);
            if(!ParamValidUtils.isEmpty(carType))carInfo.setCarType(carType);
            if(!ParamValidUtils.isEmpty(carXH))carInfo.setCarXH(carXH);
            if(!ParamValidUtils.isEmpty(carYear))carInfo.setCarYear(Integer.valueOf(carYear));
            if(!ParamValidUtils.isEmpty(carColor))carInfo.setCarColor(carColor);
            if(!ParamValidUtils.isEmpty(code))carInfo.setCode(code);

            if(carInfo==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"parameter missing");
            String page_ = request.getParameter("page");
            String limit_ = request.getParameter("limit");

            if(ParamValidUtils.isEmpty(page_))page_="1";
            if(ParamValidUtils.isEmpty(limit_))limit_="20";

            Integer page = Integer.valueOf(page_);
            Integer limit = Integer.valueOf(limit_);

            if(ParamValidUtils.isEmpty(page_))page=1;
            if(ParamValidUtils.isEmpty(limit_))limit=20;

            List list = carInfoService.get(carInfo,page,limit);
            Long total = carInfoService.count(carInfo);
            Map result = new HashMap();
            result.put("data",list);
            result.put("total",total);
            result.put("pageIndex",page);
            result.put("pageSize",list.size());

            return !list.isEmpty() ? JSONReturn.success(result):
                    JSONReturn.error(HttpCode.NOT_EXSITS,"empty");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }

    /**
     * 绑定车牌
     * @param request
     * @return
     */
    @RequestMapping(value = "/bind", method = RequestMethod.POST)
    @ResponseBody
    public JSONType bindCarNumber(HttpServletRequest request){
        try{
            CarInfo carInfo = BeanUtils.toObject(request,CarInfo.class);
            System.out.println(carInfo);
            if(carInfo==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"parameter missing");

            if(ParamValidUtils.isEmpty(request.getParameter("carNumber"))||
                    ParamValidUtils.isEmpty(request.getParameter("userId")))
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"parameter missing");

            carInfo.setId(null);
            carInfo.setCurrentUsed(0L);

            CarInfo carInfo_ = new CarInfo();
            carInfo_.setCarNumber(carInfo.getCarNumber());
            List list = carInfoService.get(carInfo_,1,1);
            if(!list.isEmpty()){
                return JSONReturn.error(Code.ERROR,"resource is exsist");
            }

            Integer rst = carInfoService.add(carInfo);
            return rst>0 ? JSONReturn.success(rst):
                    JSONReturn.error(Code.ERROR,"failed");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }


    @RequestMapping(value = "/addcn", method = RequestMethod.POST)
    @ResponseBody
    public JSONType addCarNumber(HttpServletRequest request){
        try{
            CarInfo carInfo = BeanUtils.toObject(request,CarInfo.class);
            int stat = carInfoService.add(carInfo);
            return JSONReturn.success(stat);
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"error");
        }
    }

    @RequestMapping(value = "/unbind", method = RequestMethod.POST)
    @ResponseBody
    public JSONType unBind(HttpServletRequest request){
        //TODO 绑定车牌
        return JSONReturn.success("未实现");
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    @ResponseBody
    public JSONType history(HttpServletRequest request){
        try{
            String carNum = request.getParameter("carNum");
            List list = stationOrderService.getHistory(carNum);
            return JSONReturn.success(list);
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"error");
        }
    }
}
