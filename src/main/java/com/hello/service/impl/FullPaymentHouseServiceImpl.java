package com.hello.service.impl;

import com.hello.dao.FullPaymentHouseMapper;
import com.hello.dao.FundMapper;
import com.hello.model.pojo.FullPaymentHouse;
import com.hello.model.pojo.Fund;
import com.hello.service.FullPaymentHouseService;
import com.hello.service.FundService;
import com.hello.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zane
 */
@Service("fullPaymentHouseService")
public class FullPaymentHouseServiceImpl implements FullPaymentHouseService {
    @Autowired
    private FullPaymentHouseMapper fullPaymentHouseMapper;

    @Override
    public int insert(FullPaymentHouse fullPaymentHouse) {
        return fullPaymentHouseMapper.insert(fullPaymentHouse);
    }

    @Override
    public FullPaymentHouse getFullPaymentHouseByUserId(int userId) {
        return fullPaymentHouseMapper.getFullPaymentHouseByUserId(userId);
    }

    @Override
    public int updateByPrimaryKey(FullPaymentHouse record) {
        return fullPaymentHouseMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfFullPaymentHouse(FullPaymentHouse fullPaymentHouse) {
        FullPaymentHouse oldFullPaymentHouse = fullPaymentHouseMapper.getFullPaymentHouseByUserId(fullPaymentHouse.getUserId());
        int flag1 = 0;
        int flag2 = 0;

        fullPaymentHouse.setUpdateTime(Util.getNowDateTime());
        if (oldFullPaymentHouse != null) {
            fullPaymentHouse.setFullPaymentHouseId(oldFullPaymentHouse.getFullPaymentHouseId());
            flag1 = fullPaymentHouseMapper.updateByPrimaryKeySelective(fullPaymentHouse);

        } else {
            fullPaymentHouse.setCreateTime(Util.getNowDateTime());
            flag2 = fullPaymentHouseMapper.insert(fullPaymentHouse);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }
}
