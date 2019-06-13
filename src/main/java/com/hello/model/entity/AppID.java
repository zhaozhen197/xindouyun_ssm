package com.hello.model.entity;

/**
 * Created by zane on 2017/2/20.
 */
public class AppID {
    private String appID;
    private String appSecret;

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Override
    public String toString() {
        return "AppID{" +
                "appID='" + appID + '\'' +
                ", appSecret='" + appSecret + '\'' +
                '}';
    }
}
