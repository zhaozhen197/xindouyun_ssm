package com.hello.dao;

import com.hello.model.pojo.Insurance;

public interface InsuranceMapper {
    int deleteByPrimaryKey(Integer insuranceId);

    int insert(Insurance record);

    int insertSelective(Insurance record);

    Insurance selectByPrimaryKey(Integer insuranceId);

    int updateByPrimaryKeySelective(Insurance record);

    int updateByPrimaryKey(Insurance record);

    Insurance selectInsuranceByUserId(int userId);
}