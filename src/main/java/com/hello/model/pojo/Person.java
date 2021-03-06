package com.hello.model.pojo;

import java.util.Date;

public class Person {
    private Integer personId;

    private Integer userId;

    private String userPhone;

    private Integer personalExpenses;

    private Integer cashExpenses;

    private String operationYears;

    private String locationOfCompany;

    private Byte license;

    private Date createTime;

    private Date updateTime;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
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

    public Integer getPersonalExpenses() {
        return personalExpenses;
    }

    public void setPersonalExpenses(Integer personalExpenses) {
        this.personalExpenses = personalExpenses;
    }

    public Integer getCashExpenses() {
        return cashExpenses;
    }

    public void setCashExpenses(Integer cashExpenses) {
        this.cashExpenses = cashExpenses;
    }

    public String getOperationYears() {
        return operationYears;
    }

    public void setOperationYears(String operationYears) {
        this.operationYears = operationYears == null ? null : operationYears.trim();
    }

    public String getLocationOfCompany() {
        return locationOfCompany;
    }

    public void setLocationOfCompany(String locationOfCompany) {
        this.locationOfCompany = locationOfCompany == null ? null : locationOfCompany.trim();
    }

    public Byte getLicense() {
        return license;
    }

    public void setLicense(Byte license) {
        this.license = license;
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