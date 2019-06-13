package com.hello.model.pojo;

import java.util.Date;

public class Insurance {
    private Integer insuranceId;

    private Integer userId;

    private String userPhone;

    private Integer insuranceOrNot;

    private String companyOfInsurance;

    private Integer moneyOfYearInsurance;

    private Integer yearsOfInsurance;

    private Date createTime;

    private Date updateTime;

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
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

    public Integer getInsuranceOrNot() {
        return insuranceOrNot;
    }

    public void setInsuranceOrNot(Integer insuranceOrNot) {
        this.insuranceOrNot = insuranceOrNot;
    }

    public String getCompanyOfInsurance() {
        return companyOfInsurance;
    }

    public void setCompanyOfInsurance(String companyOfInsurance) {
        this.companyOfInsurance = companyOfInsurance == null ? null : companyOfInsurance.trim();
    }

    public Integer getMoneyOfYearInsurance() {
        return moneyOfYearInsurance;
    }

    public void setMoneyOfYearInsurance(Integer moneyOfYearInsurance) {
        this.moneyOfYearInsurance = moneyOfYearInsurance;
    }

    public Integer getYearsOfInsurance() {
        return yearsOfInsurance;
    }

    public void setYearsOfInsurance(Integer yearsOfInsurance) {
        this.yearsOfInsurance = yearsOfInsurance;
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