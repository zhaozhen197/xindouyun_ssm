package com.hello.service;

import com.hello.model.pojo.BusinessOwner;

public interface BusinessOwnerService {
    public int insert(BusinessOwner businessOwner);


    public BusinessOwner getBusinessOwnerByUserId(int userId);


    public int updateByPrimaryKey(BusinessOwner record);

    public boolean inputOfBusinessOwner(BusinessOwner businessOwner);
}
