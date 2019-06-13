package com.hello.dao;

import com.hello.model.pojo.FullPaymentHouse;

public interface FullPaymentHouseMapper {
    int deleteByPrimaryKey(Integer fullPaymentHouseId);

    int insert(FullPaymentHouse record);

    int insertSelective(FullPaymentHouse record);

    FullPaymentHouse selectByPrimaryKey(Integer fullPaymentHouseId);

    int updateByPrimaryKeySelective(FullPaymentHouse record);

    int updateByPrimaryKey(FullPaymentHouse record);

    FullPaymentHouse getFullPaymentHouseByUserId(int userid);
}