package com.cloud.station.fare.api;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.station.fare.api.impl.DayFare;
import com.cloud.station.fare.api.impl.FrontN;
import com.cloud.station.fare.api.impl.NormalFare;
import com.cloud.station.fare.api.impl.StepChargeFare;
import com.cloud.station.fare.entity.*;
import com.cloud.station.fare.entity.dto.DayChargeDTO;
import com.cloud.station.fare.entity.dto.StepChargeDTO;
import com.fasterxml.jackson.databind.ser.Serializers;

import java.util.List;

public class ChargeApi {

    public static Integer MODE_BY_DAY = 0;//按天按小时收费
    public static Integer MODE_BY_NORMAL = 1;//正常计费  y/th   每t小时y元
    public static Integer MODE_BY_STEP = 2;//梯步价格计费

    private Rule rule;

    private FNCharg fnCharg;
    private Normal normal;
    private DayChargeDTO dayChargeDTO;
    private StepChargeDTO stepChargeDTO;
    private BaseCharge baseCharge;

    public ChargeApi(Rule rule) {
        this.rule = rule;
        this.parseRule();
    }

    public float calc(){
        float money = 0;
        if(rule.getMode()==MODE_BY_DAY){
            money = fareByDay();
        }else if(rule.getMode()==MODE_BY_STEP){
            money = fareByStep();
        }

        //TODO 这里应采用银行进位法
        String moneyStr = String.format("%.2f",money);

        return money<=0?0:Float.valueOf(moneyStr);
    }

    private float fareByStep(){
        float money = 0;
        //前n小时计费
        money+=(new FrontN()).calc(stepChargeDTO.getFnCharg(), rule.getTotalTime());
        //梯步价格
        money+=(new StepChargeFare()).calc(stepChargeDTO.getStepChargeList(),stepChargeDTO.getBaseCharge(),rule.getTotalTime(),stepChargeDTO.getMax_money());

        //超过梯步价格收费
        money+=(new NormalFare()).calc(stepChargeDTO.getNormal(),rule.getTotalTime());

        return money;
    }

    //正常计费  0-n
    private float fareByNormal(){
        Normal normal = JSONArray.parseObject(rule.getRule(),Normal.class);
        normal.setT0(0);
        return (new NormalFare()).calc(normal,rule.getTotalTime());
    }

    //按天按小时收费
    private float fareByDay(){

        if(dayChargeDTO!=null && dayChargeDTO.getDayChargeList()!=null)
            return (new DayFare()).calc(dayChargeDTO.getDayChargeList(),
                    dayChargeDTO.getBaseCharge(),rule.getStartTime(),rule.getEndTime());
        return 0;
    }

    /**
     * 解析规则
     */
    private void parseRule(){
        if(rule.getMode()==MODE_BY_DAY){
            try{
                dayChargeDTO = JSONArray.parseObject(rule.getRule(),DayChargeDTO.class);

            }catch (Exception e){
                e.printStackTrace();
                dayChargeDTO = null;
            }
        }

        if(rule.getMode()==MODE_BY_STEP){
            try{

                stepChargeDTO = JSONArray.parseObject(rule.getRule(),StepChargeDTO.class);
            }catch (Exception e){
                stepChargeDTO = null;
            }
        }

        if(rule.getMode()==MODE_BY_NORMAL){
            try{
                normal = JSONArray.parseObject(rule.getRule(),Normal.class);
            }catch (Exception e){
                normal = null;
            }
        }
    }
}
