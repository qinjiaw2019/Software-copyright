package com.cloud.station.controller;

import com.cloud.station.constant.HttpCode;
import com.cloud.station.mapper.StationOrderMapper;
import com.cloud.station.pojo.StationOrder;
import com.cloud.station.utils.ParamValidUtils;
import com.cloud.station.utils.result.JSONReturn;
import com.cloud.station.utils.result.JSONType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/stationorder")
public class StationOrderController {

    @Autowired
    StationOrderMapper stationOrderMapper;

    /**
     * 根据停车场ID获取使用停车场的用户信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public JSONType getAllUsers(HttpServletRequest request){
        try{
            String stationId = request.getParameter("stationId");
            String page = request.getParameter("page");
            String limit = request.getParameter("limit");

            if(ParamValidUtils.isEmpty(stationId))
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"paramter missing");

            if(ParamValidUtils.isEmpty(page))page="1";
            if(ParamValidUtils.isEmpty(limit))limit="20";

            StationOrder stationOrder = new StationOrder();
            stationOrder.setStationId(Long.valueOf(stationId));

            List list = stationOrderMapper.findUserByEntity(stationOrder,Integer.valueOf(page),Integer.valueOf(limit));

            Map map = new HashMap();
            map.put("total",stationOrderMapper.count());
            map.put("data",list);
            return JSONReturn.success(map);
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"error");
        }

    }
}
