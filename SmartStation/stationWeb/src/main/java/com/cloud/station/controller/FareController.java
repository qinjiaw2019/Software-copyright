package com.cloud.station.controller;

import com.cloud.station.constant.Code;
import com.cloud.station.constant.HttpCode;
import com.cloud.station.pojo.FareRule;
import com.cloud.station.service.FareService;
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
import java.util.List;

@Controller
@RequestMapping("/v1/fare")
public class FareController {

    @Autowired
    FareService fareService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JSONType add(HttpServletRequest request){
        try{
            FareRule fareRule = BeanUtils.toObject(request,FareRule.class);

            if(fareRule==null){
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"paramter missing");
            }
            if(fareRule.getStationId()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"station id required");
            if(fareRule.getUserId()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"user id required");

            fareRule.setId(null);
            fareRule.setCreateTime(new Date().getTime());

            //查询当前停车场是否有正在使用的规则
            FareRule fareRule_ = fareService.getUsedByStationId(fareRule.getStationId());

            if(fareRule_!=null){
                fareRule.setUsed(0);//强制设置成未使用
            }

            Integer rst = fareService.save(fareRule);

            if(fareRule_==null)//如果不存在
                return rst==1 ? JSONReturn.success(Code.SUCCESS,"success") :
                        JSONReturn.error(Code.ERROR,"failed");
            else
                return rst==1 ? JSONReturn.success(HttpCode.RESOURCE_RESET,"used is seted UNUSED") :
                        JSONReturn.error(Code.ERROR,"failed");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }

    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public JSONType deleteById(HttpServletRequest request){
        try{
            String id_ = request.getParameter("id");
            if(ParamValidUtils.isEmpty(id_))
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"id required");

            int rst = fareService.deleteByPrimaryKey(Long.valueOf(id_));

            return rst>0 ? JSONReturn.success(rst) :
                    JSONReturn.error(Code.ERROR,"failed");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public JSONType getById(HttpServletRequest request){
        try{
            String id_ = request.getParameter("id");
            if(ParamValidUtils.isEmpty(id_))
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"id required");

            FareRule fareRule = (FareRule) fareService.findByPrimaryKey(Long.valueOf(id_));

            return fareRule!=null ? JSONReturn.success(fareRule) :
                    JSONReturn.error(Code.ERROR,"failed");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public JSONType update(HttpServletRequest request){
        try{
            FareRule fareRule = BeanUtils.toObject(request,FareRule.class);
            if(fareRule==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"error");
            if(fareRule.getId()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"id requied");
            if(fareRule.getUserId()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"user id requied");
            if(fareRule.getStationId()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"station id requied");

            FareRule fareRule_ = fareService.getUsedByStationId(fareRule.getStationId());

            if(fareRule_!=null){
                fareRule.setUsed(0);
            }

            int rst = fareService.update(fareRule);

            if(fareRule_==null)
                return rst>0 ? JSONReturn.success() :
                        JSONReturn.error(Code.ERROR,"failed");
            else
                return rst>0 ? JSONReturn.success("used will be seted 0") :
                        JSONReturn.error(Code.ERROR,"failed");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }

    /**
     * 查询所有
     * @param request
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONType getAll(HttpServletRequest request){
        try{
            String stationId_ = request.getParameter("uid");
            if(ParamValidUtils.isEmpty(stationId_))
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"sid required");

            List<FareRule> list = fareService.getAll(Long.valueOf(stationId_));


            return !list.isEmpty() ? JSONReturn.success(list) :
                    JSONReturn.error(HttpCode.RESULT_EMPTY,"empty");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }

    /**
     * 设置规则为当前使用的规则
     * @param request
     * @return
     */
    @RequestMapping(value = "/update/used", method = RequestMethod.POST)
    @ResponseBody
    public JSONType updateUsed(HttpServletRequest request){
        try{
            String id_ = request.getParameter("id");
            String used_ = request.getParameter("used");

            Integer used = Integer.valueOf(used_);

            if(ParamValidUtils.isEmpty(id_))
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"id required");

            //used必须是0或者1
            if(used!=0 && used!=1)
                return JSONReturn.error(HttpCode.INVALIED_AUTHORITY,"used valied");

            FareRule fareRule = (FareRule) fareService.findByPrimaryKey(Long.valueOf(id_));
            FareRule usedFareRule = fareService.getUsedByStationId(fareRule.getStationId());

            if(usedFareRule!=null){//存在规则正在被使用
                if(used==1){//修改
                    usedFareRule.setUsed(0);
                    fareRule.setUsed(1);
                }else{
                    fareRule.setUsed(0);
                }
                fareService.update(usedFareRule);
            }else{
                fareRule.setUsed(used);
            }


            int rst = fareService.update(fareRule);

            return rst>0 ? JSONReturn.success("success") :
                    JSONReturn.error(Code.ERROR,"failed");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }
}
