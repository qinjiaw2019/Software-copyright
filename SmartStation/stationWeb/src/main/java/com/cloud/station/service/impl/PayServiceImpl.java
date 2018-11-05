package com.cloud.station.service.impl;

import com.cloud.station.fare.api.ChargeApi;
import com.cloud.station.fare.entity.Rule;
import com.cloud.station.mapper.CarInfoMapper;
import com.cloud.station.mapper.CarNumberUsingMapper;
import com.cloud.station.mapper.UserInfoMapper;
import com.cloud.station.pojo.*;
import com.cloud.station.service.FareService;
import com.cloud.station.service.PayService;
import com.cloud.station.service.StationOrderService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("payService")
public class PayServiceImpl implements PayService{

    @Autowired
    CarInfoMapper carInfoMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    CarNumberUsingMapper carNumberUsingMapper;

    @Autowired
    StationOrderService stationOrderService;

    @Autowired
    FareService fareService;
    /**
     * 根据车牌扣费
     *
     * @param carNumber
     * @return
     */
    @Override
    public float pay(String carNumber,Long endTime) {
        try {
            //1.根据车牌查询车牌的信息
            CarInfo carInfo = carInfoMapper.getByCarNumber(carNumber);
            //2.查出使用车牌的用户信息
            UserInfo userInfo = (UserInfo) userInfoMapper.findByPrimaryKey(carInfo.getCurrentUsed());
            //3.查询出当前车牌的使用情况
            CarNumberUsing  carNumberUsing = (CarNumberUsing) carNumberUsingMapper.getByCarNumberId(carInfo.getId(),1);

            Long usedTimeMs = carNumberUsing.getEndTime()-endTime;//使用时间(毫秒)

            //计算费用
            float money = calculate(usedTimeMs);

            //计算余额
            float leftMoney = userInfo.getMoney()-money;
            leftMoney = Float.valueOf(String.format("%.2f",leftMoney));//保留两位小数
            if(leftMoney>=0){
                //更新用户数据
                userInfo.setMoney(leftMoney);
                //增加信誉
                userInfo.setReputationPoints(userInfo.getReputationPoints()+5);//TODO 增加信誉度
                userInfoMapper.update(userInfo);

                //更新车牌使用数据
                carNumberUsing.setEndTime(endTime);//更新数据
                carNumberUsing.setState(2);
                carNumberUsingMapper.update(carNumberUsing);

                //更新当前使用车牌数据
                carInfo.setCurrentUsed(0L);
                carInfoMapper.update(carInfo);

                return leftMoney;
            }

            //余额不足
            //更新使用车牌数据
            carNumberUsing.setState(3);
            carNumberUsing.setEndTime(endTime);
            carNumberUsingMapper.update(carNumberUsing);


            //更新车牌数据
            carInfo.setCurrentUsed(0L);
            carInfoMapper.update(carInfo);

            //更新用户数据
            userInfo.setMoney(leftMoney);//余额复数
            userInfo.setReputationPoints(userInfo.getReputationPoints()-5);////TODO 扣除信誉度 增加一个不良记录
            userInfoMapper.update(userInfo);
            return leftMoney;
        } catch (Exception e) {
           return -1;
        }
    }

    /**
     * 根据停车和停车场ID付款
     *
     * @param stationId
     * @param carNum
     * @return
     */
    @Override
    public float pay(Long stationId, String carNum) {
        //1.获取车牌信息
        StationOrder stationOrder = stationOrderService.getByStationIdAndCarNuber(stationId,carNum);

        if(stationOrder==null)return -1;
        //如果订单已被处理
        if(stationOrder.getEndTime()>0 ||
                stationOrder.getState()==StationOrder.NORMAL ||
                stationOrder.getUserId()!=null)
            return -1;

        //2.根据车牌找到当前使用者的用户信息
        try {
            //找到当前使用者相关的车主绑定的车牌信息
            CarInfo carInfo = carInfoMapper.getByCarNumber(carNum);
            //当前使用者的用户信息
            UserInfo userInfo = (UserInfo) userInfoMapper.findByPrimaryKey(carInfo.getCurrentUsed());

            int usedTimeMs = Integer.valueOf((int) ((new Date().getTime()-stationOrder.getCreateTime())/1000/60/60));//使用时间(毫秒)
            /**
             * 计算费用
             */
            //1.获得计费规则
            FareRule fareRule = fareService.getUsedByStationId(stationId);
            Rule rule = new Rule();
            rule.setRule(fareRule.getRule());
            rule.setMode(fareRule.getMode());
            rule.setTotalTime(usedTimeMs);
            rule.setStartTime(stationOrder.getCreateTime()/1000/60/60);//小时数
            rule.setEndTime((new Date().getTime())/1000/60/60);
//            rule.setEndTime(1523671463702L+8*60*60*1000);8小时
            float fareTotal = (new ChargeApi(rule)).calc();//总费用

            if(usedTimeMs>=0){//时间有效
                float leftMoney = userInfo.getMoney()-fareTotal;//扣除后用户余额

                //扣费
                //1.用户余额不足
                if(leftMoney<=0){
                    userInfo.setReputationPoints(reputationPoint(userInfo,0));//计算信誉度

                    stationOrder.setState(StationOrder.UNDO_MONEY);//欠费
                }else{//用户余额够
                    userInfo.setRankPoints(rankPoint(userInfo));//计算积分
                    userInfo.setReputationPoints(reputationPoint(userInfo,1));//计算信誉度

                    stationOrder.setState(StationOrder.NORMAL);
                }
                //用户余额
                userInfo.setMoney(leftMoney);

                //更新用户信息
                userInfoMapper.update(userInfo);

                //更新车牌信息
                carInfo.setCurrentUsed(0L);//释放当前使用者
                carInfoMapper.update(carInfo);

                //更新订单信息
                stationOrder.setEndTime(new Date().getTime());
                stationOrder.setUserId(userInfo.getId());
                stationOrderService.update(stationOrder);

                return fareTotal;//返回消费
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 计算费用
     * @param starTime
     * @return
     */
    private float calculate(float starTime){
        //TODO 计算总费用
        return 10;
    }


    /**
     * 支付宝扣费
     * @return
     */
    private boolean alipay(){

        return true;
    }

    //

    /**
     * TODO 计算信誉度
     * @param userInfo 用户信息
     * @param mode 模式0:余额不足   1:余额足
     * @return
     */
    private float reputationPoint(UserInfo userInfo,Integer mode){
        return userInfo.getReputationPoints()-5;
    }

    //TODO 计算积分
    private float rankPoint(UserInfo userInfo){
        return userInfo.getRankPoints()+5;
    }
}
