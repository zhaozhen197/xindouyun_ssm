package com.hello.service.impl;

import com.hello.dao.BusinessOwnerMapper;
import com.hello.model.pojo.BusinessOwner;
import com.hello.service.BusinessOwnerService;
import com.hello.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bussinessOwnerService")
public class BusinessOwnerServiceImpl implements BusinessOwnerService {

    @Autowired
    private BusinessOwnerMapper businessOwnerMapper;

    @Override
    public int insert(BusinessOwner businessOwner) {
        return businessOwnerMapper.insert(businessOwner);
    }

    @Override
    public BusinessOwner getBusinessOwnerByUserId(int userId) {
        return businessOwnerMapper.getBusinessOwnerByUserId(userId);
    }

    @Override
    public int updateByPrimaryKey(BusinessOwner record) {
        return businessOwnerMapper.updateByPrimaryKey(record);
    }


    @Override
    public boolean inputOfBusinessOwner(BusinessOwner businessOwner) {
        BusinessOwner oldBusinessOwner = businessOwnerMapper.getBusinessOwnerByUserId(businessOwner.getUserId());
        int flag1 = 0;
        int flag2 = 0;

        businessOwner.setUpdateTime(Util.getNowDateTime());
        if (oldBusinessOwner != null) {
            businessOwner.setBusinessOwnerId(oldBusinessOwner.getBusinessOwnerId());
            flag1 = businessOwnerMapper.updateByPrimaryKeySelective(businessOwner);
        } else {
            businessOwner.setCreateTime(Util.getNowDateTime());
            flag2 = businessOwnerMapper.insert(businessOwner);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }

}
