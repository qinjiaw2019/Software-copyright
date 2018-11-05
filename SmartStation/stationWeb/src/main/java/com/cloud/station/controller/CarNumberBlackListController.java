package com.cloud.station.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.station.constant.HttpCode;
import com.cloud.station.pojo.CarNumberBlacklist;
import com.cloud.station.service.CarNumberBlackListService;
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
@RequestMapping("/v1/carblacklist")
public class CarNumberBlackListController {

    @Autowired
    CarNumberBlackListService carNumberBlackListService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JSONType add(HttpServletRequest request){
        try{
            CarNumberBlacklist carNumberBlacklist = BeanUtils.toObject(request,CarNumberBlacklist.class);
            if(carNumberBlacklist==null)
                return JSONReturn.error(HttpCode.INVALIED_AUTHORITY,"invalied");
            if(carNumberBlacklist.getCarNum()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"car number required");
            int rst = 0;

             carNumberBlacklist.setOweTime(new Date().getTime());
             carNumberBlacklist.setId(null);
             carNumberBlacklist.setOweAmount(0);
             carNumberBlacklist.setDisposeTime(new Date().getTime());
             carNumberBlacklist.setOweMoneyTime(1L);
             rst = carNumberBlackListService.save(carNumberBlacklist);
            return rst>0 ? JSONReturn.success(rst) :
                    JSONReturn.error(HttpCode.INVALIED_AUTHORITY,"failed");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public JSONType update(HttpServletRequest request){
        try{
            CarNumberBlacklist carNumberBlacklist = BeanUtils.toObject(request,CarNumberBlacklist.class);
            if(carNumberBlacklist==null)
                return JSONReturn.error(HttpCode.INVALIED_AUTHORITY,"invalied");
            if(carNumberBlacklist.getId()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"id required");

            carNumberBlacklist.setDisposeTime(new Date().getTime());
            int rst = carNumberBlackListService.update(carNumberBlacklist);

            return rst>0 ? JSONReturn.success(rst) :
                    JSONReturn.error(HttpCode.INVALIED_AUTHORITY,"failed");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }
    @RequestMapping(value = "/del/id", method = RequestMethod.POST)
    @ResponseBody
    public JSONType deleteById(HttpServletRequest request){
        try{
            String id_ = request.getParameter("id");
            if(ParamValidUtils.isEmpty(id_))
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"id required");

            int rst = carNumberBlackListService.deleteByPrimaryKey(Long.valueOf(id_));
            return rst>0 ? JSONReturn.success(rst) :
                    JSONReturn.error(HttpCode.INVALIED_AUTHORITY,"failed");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }

    @RequestMapping(value = "/get/id", method = RequestMethod.GET)
    @ResponseBody
    public JSONType getById(HttpServletRequest request){
        try{
            String id_ = request.getParameter("id");
            if(ParamValidUtils.isEmpty(id_))
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"id required");

            CarNumberBlacklist carNumberBlacklist = (CarNumberBlacklist) carNumberBlackListService.findByPrimaryKey(Long.valueOf(id_));
            return carNumberBlacklist!=null ? JSONReturn.success(carNumberBlacklist) :
                    JSONReturn.error(HttpCode.INVALIED_AUTHORITY,"failed");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }

    /**
     * 根据车牌查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/get/number", method = RequestMethod.GET)
    @ResponseBody
    public JSONType getByCarNumber(HttpServletRequest request){
        try{
            String page_ = request.getParameter("page");
            String limit_ = request.getParameter("limit");
            String carNum = request.getParameter("carNum");

            if(ParamValidUtils.isEmpty(page_))page_="1";
            if(ParamValidUtils.isEmpty(limit_))limit_="20";

            if(ParamValidUtils.isEmpty(carNum))
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"car number required");

            Integer page = Integer.valueOf(page_);
            Integer limit = Integer.valueOf(limit_);

            List<CarNumberBlacklist> list = carNumberBlackListService.getByCarNumber(carNum,page,limit);

            Long total = carNumberBlackListService.countFilterByCarNum(carNum);
            Map map = new HashMap();
            map.put("data",list);
            map.put("total",total);
            return (list!=null && !list.isEmpty()) ? JSONReturn.success(map) :
                    JSONReturn.error(HttpCode.RESULT_EMPTY,"empty");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }
}
