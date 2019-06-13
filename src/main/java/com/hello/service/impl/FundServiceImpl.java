package com.hello.service.impl;

import com.hello.dao.FundMapper;
import com.hello.model.pojo.Fund;
import com.hello.service.FundService;
import com.hello.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fundService")
public class FundServiceImpl implements FundService {
    @Autowired
    private FundMapper fundMapper;

    @Override
    public int insert(Fund fund) {
        return fundMapper.insert(fund);
    }

    @Override
    public Fund getFundByUserId(int userId) {
        return fundMapper.getFundByUserId(userId);
    }

    @Override
    public int updateByPrimaryKey(Fund record) {
        return fundMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfFund(Fund fund) {
        Fund oldFund = fundMapper.getFundByUserId(fund.getUserId());
        int flag1 = 0;
        int flag2 = 0;

        fund.setUpdateTime(Util.getNowDateTime());
        if (oldFund != null) {
            fund.setFundId(oldFund.getFundId());
            flag1 = fundMapper.updateByPrimaryKeySelective(fund);
        } else {
            fund.setCreateTime(Util.getNowDateTime());
            flag2 = fundMapper.insert(fund);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }


}
