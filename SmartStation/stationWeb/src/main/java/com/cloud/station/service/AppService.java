package com.cloud.station.service;

import com.cloud.station.base.BaseService;

/**
 * @className:     AppService
 * @data:          2018-03-06
 * @lastModify:    2018-03-06
 * @description:  手机APP公共Service接口
 */
public interface AppService extends BaseService {

    /**
     * 获取对应平台最新的APP版本
     * @param platform 平台
     * @return
     */
    public String getLastVersion(String platform);

    /**
     * 更新手机APP版本
     * @param platform 平台
     * @param version  版本
     * @return
     */
    public String updateApp(String platform, String version);

    /**
     * 下载APP
     * @param platform 平台
     * @param version  版本
     * @return
     */
    public String dowloadApp(String platform, String version);
}
