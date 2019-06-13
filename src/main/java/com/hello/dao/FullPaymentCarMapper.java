package com.hello.dao;

import com.hello.model.pojo.BusinessOwner;
import com.hello.model.pojo.FullPaymentCar;

public interface FullPaymentCarMapper {
    int deleteByPrimaryKey(Integer fullPaymentCarId);

    int insert(FullPaymentCar record);

    int insertSelective(FullPaymentCar record);

    FullPaymentCar selectByPrimaryKey(Integer fullPaymentCarId);

    int updateByPrimaryKeySelective(FullPaymentCar record);

    int updateByPrimaryKey(FullPaymentCar record);

    FullPaymentCar selectFullPaymentCarByUserId(int userId);
}