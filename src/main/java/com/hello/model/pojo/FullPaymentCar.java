package com.hello.model.pojo;

import java.util.Date;

public class FullPaymentCar {
    private Integer fullPaymentCarId;

    private Integer userId;

    private String userPhone;

    private Integer carValue;

    private Integer carYears;

    private Date createTime;

    private Date updateTime;

    public Integer getFullPaymentCarId() {
        return fullPaymentCarId;
    }

    public void setFullPaymentCarId(Integer fullPaymentCarId) {
        this.fullPaymentCarId = fullPaymentCarId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getCarValue() {
        return carValue;
    }

    public void setCarValue(Integer carValue) {
        this.carValue = carValue;
    }

    public Integer getCarYears() {
        return carYears;
    }

    public void setCarYears(Integer carYears) {
        this.carYears = carYears;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}