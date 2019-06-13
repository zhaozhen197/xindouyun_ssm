package com.hello.dao;

import com.hello.model.pojo.Other;

public interface OtherMapper {
    int deleteByPrimaryKey(Integer otherId);

    int insert(Other record);

    int insertSelective(Other record);

    Other selectByPrimaryKey(Integer otherId);

    int updateByPrimaryKeySelective(Other record);

    int updateByPrimaryKey(Other record);

    Other getOtherByUserId(int userId);

}