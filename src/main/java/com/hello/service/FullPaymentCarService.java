package com.hello.service;

import com.hello.model.pojo.FullPaymentCar;
import com.hello.model.pojo.FullPaymentHouse;
import com.hello.model.pojo.Fund;

/**
 * @author zane
 */
public interface FullPaymentCarService {

    int deleteByPrimaryKey(Integer fullPaymentCarId);

    int insert(FullPaymentCar record);

    int insertSelective(FullPaymentCar record);

    FullPaymentCar selectByPrimaryKey(Integer fullPaymentCarId);

    int updateByPrimaryKeySelective(FullPaymentCar record);

    int updateByPrimaryKey(FullPaymentCar record);

    public boolean inputOfFullPaymentCar(FullPaymentCar fullPaymentCar);
}
