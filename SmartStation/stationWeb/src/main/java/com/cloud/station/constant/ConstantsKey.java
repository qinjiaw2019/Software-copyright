package com.cloud.station.constant;

public interface ConstantsKey {

    //登陆方式常量
    Integer LOGIN_METHOD_OF_PASSWORD = 0;//密码登陆
    Integer PASSWORD_MIN_LEN = 6;//密码最短位数
    Integer PASSWORD_MAX_LEN = 12;//密码最长位数

    boolean IS_PHONE_NUMBER = true;//是手机号码
    boolean IS_NOT_PHONE_NUMBER = false;//不是手机密码

    //金额范围
    Long MONEY_MIN = 0L;//最小金额
    Long MONEY_MAX = 100000L;//最大金额

    //余额充值方式
    Integer PAY_ZHIFUBAO = 0;//支付宝充值
    Integer PAY_WECHART = 1;//微信支付
    
    String LOGIN_SESSION_TOKEN = "id";//登陆成功后保存在session中的标志token
    
    //
    String SOCKET_LISTENER_PORT = "socket.port";

    String HADWARE_AUTHORYIZE_KEY = "KEY";//硬件认证


    //Redis缓存key外键前缀
    String STATION_STATE_PREFIX = "depotStationState-id@";//停车场状态key前缀

    //管理员类型
    Integer ADMIN = 1;//网站管理员
    Integer STATION_ADMIN = 0;//停车场管理员
    Integer PRIMARY_USER = 2;//普通管理员
}
