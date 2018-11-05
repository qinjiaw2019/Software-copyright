package com.cloud.station.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * 从spring容器中获取bean
 */
@Configuration
public class BeanTools implements ApplicationContextAware {
    private static ApplicationContext applicationContext;


    public  void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public  static Object getBean(Class classname) {
        try{
            Object _restTemplate = applicationContext.getBean(classname);
            return _restTemplate;
        }catch(Exception e){
            return "";
        }
    }


    public static void setApplicationContext1(ApplicationContext context) {
        applicationContext = context;
    }
}