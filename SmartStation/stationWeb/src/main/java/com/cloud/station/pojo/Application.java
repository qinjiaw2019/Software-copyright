package com.cloud.station.pojo;

/**
 * 应用实体
 */
public class Application {

    //主键
    private Long id;

    //应用名称
    private String name;

    //应用描述
    private String desc;

    //应用ID号
    private String appKey;

    //应用密钥
    private String appSecrte;

    //停车场管理员ID
    private String adminId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecrte() {
        return appSecrte;
    }

    public void setAppSecrte(String appSecrte) {
        this.appSecrte = appSecrte;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
