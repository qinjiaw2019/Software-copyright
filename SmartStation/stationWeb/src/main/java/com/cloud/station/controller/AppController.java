package com.cloud.station.controller;

import com.cloud.station.conf.ConfigurationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @className:     AppController
 * @data:          2018-03-06
 * @lastModify:    2018-03-06
 * @description:   APP Controller
 * @version         v1
 */
@Controller
@RequestMapping("/v1/app")
public class AppController {

    public static String APK_UPLOAD_DIR = "apk.upload.dir" ;

    /**
     * 获取APP的版本
     * @return      版本信息
     */
    @RequestMapping(value = "/v", method = RequestMethod.GET)
    @ResponseBody
    public Object getVersion(HttpServletRequest request){
        //TODO /v1/app/v
        return "success";
    }

    /**
     * 更具平台和版本下载APK文件
     * @method     POST
     * @url        /v1/app/app
     * @param request
     *              platform[String]  平台
     *              v[String]          版本
     * @return      下载
     */
    @RequestMapping(value = "/app", method = RequestMethod.POST)
    @ResponseBody
    public Object dowonloadApp(HttpServletRequest request){
        //TODO /v1/app/app
    	return null;
    }

    /**
     * 上传APK安装包
     * @method     POST
     * @url        /v1/app/upload
     * @param request
     *              platform[String]  平台
     *              v[String]          版本
     * @return      下载
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadApp(HttpServletRequest request){
        String dir = ConfigurationManager.getProperty(APK_UPLOAD_DIR);

        //TODO /v1/app/upload
    	return null;
    }
}
