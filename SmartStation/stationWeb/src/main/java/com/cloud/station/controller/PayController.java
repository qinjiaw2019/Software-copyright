package com.cloud.station.controller;

import com.cloud.station.constant.HttpCode;
import com.cloud.station.service.PayService;
import com.cloud.station.utils.ParamValidUtils;
import com.cloud.station.utils.result.JSONReturn;
import com.cloud.station.utils.result.JSONType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/v1/pay")
public class PayController {

    @Autowired
    PayService payService;
    /**
     * 收费
     * @param request
     * @return
     */
    @RequestMapping(value = "/p", method = RequestMethod.POST)
    @ResponseBody
    public JSONType updateUsed(HttpServletRequest request){
        try{
            String uid = request.getParameter("uid");//用户ID
            String carNum = request.getParameter("carNum");//车牌
            if(ParamValidUtils.isEmpty(carNum))
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"paramter missing");

            float leftMoney = payService.pay(carNum,new Date().getTime());
            return JSONReturn.success(leftMoney);
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"error");
        }

    }


}
