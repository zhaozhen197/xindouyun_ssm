package com.hello.service;

import com.hello.model.pojo.Insurance;

public interface InsuranceService {
    int deleteByPrimaryKey(Integer insuranceId);

    int insert(Insurance record);

    int insertSelective(Insurance record);

    Insurance selectByPrimaryKey(Integer insuranceId);

    int updateByPrimaryKeySelective(Insurance record);

    int updateByPrimaryKey(Insurance record);

    boolean inputOfInsurance(Insurance insurance);

}