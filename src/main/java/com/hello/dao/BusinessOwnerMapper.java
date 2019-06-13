package com.hello.dao;

import com.hello.model.pojo.BusinessOwner;

public interface BusinessOwnerMapper {
    int deleteByPrimaryKey(Integer businessOwnerId);

    int insert(BusinessOwner record);

    int insertSelective(BusinessOwner record);

    BusinessOwner selectByPrimaryKey(Integer businessOwnerId);

    int updateByPrimaryKeySelective(BusinessOwner record);

    int updateByPrimaryKey(BusinessOwner record);
    BusinessOwner getBusinessOwnerByUserId(int userId);

}