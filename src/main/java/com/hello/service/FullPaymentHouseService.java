package com.hello.service;

import com.hello.model.pojo.FullPaymentHouse;
import com.hello.model.pojo.Fund;

public interface FullPaymentHouseService {

    public int insert(FullPaymentHouse fullPaymentHouse);


    public FullPaymentHouse getFullPaymentHouseByUserId(int userId);


    public int updateByPrimaryKey(FullPaymentHouse record);

    public boolean inputOfFullPaymentHouse(FullPaymentHouse fullPaymentHouse);

}
