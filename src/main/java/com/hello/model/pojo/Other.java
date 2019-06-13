package com.hello.model.pojo;

import java.util.Date;

public class Other {
    private Integer otherId;

    private Integer userId;

    private String userPhone;

    private Integer cashIncome;

    private Date creationTime;

    private Date updateTime;

    public Integer getOtherId() {
        return otherId;
    }

    public void setOtherId(Integer otherId) {
        this.otherId = otherId;
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

    public Integer getCashIncome() {
        return cashIncome;
    }

    public void setCashIncome(Integer cashIncome) {
        this.cashIncome = cashIncome;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}