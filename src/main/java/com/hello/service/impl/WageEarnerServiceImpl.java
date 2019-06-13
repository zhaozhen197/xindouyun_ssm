package com.hello.service.impl;

import com.hello.dao.WageEarnerMapper;
import com.hello.model.pojo.WageEarner;
import com.hello.service.WageEarnerService;
import com.hello.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wageEarnerService")
public class WageEarnerServiceImpl implements WageEarnerService {
    @Autowired
    private WageEarnerMapper wageEarnerMapper;


    @Override
    public int insert(WageEarner wageEarner) {

        return wageEarnerMapper.insert(wageEarner);
    }

    @Override
    public WageEarner getWageEarnerByUserId(int userId) {
        return wageEarnerMapper.getWageEarnerByUserId(userId);
    }

    @Override
    public int updateByPrimaryKey(WageEarner record) {
        return wageEarnerMapper.updateByPrimaryKey(record);
    }

    /**
     * 保存输入的wageEarner信息，如果该用户之前已经提交过信息了，那么就是更新用户的信息，没有的话就插入
     * @param wageEarner
     * @return
     */
    @Override
    public boolean inputOfWageEarner(WageEarner wageEarner) {
        WageEarner oldWageEarner = wageEarnerMapper.getWageEarnerByUserId(wageEarner.getUserId());
        int flag1 = 0;
        int flag2 = 0;

        wageEarner.setUpdateTime(Util.getNowDateTime());
        if (oldWageEarner != null) {
            wageEarner.setWageEarnerId(oldWageEarner.getWageEarnerId());
            flag1 = wageEarnerMapper.updateByPrimaryKeySelective(wageEarner);
        }else {
            wageEarner.setCreateTime(Util.getNowDateTime());
            flag2 =  wageEarnerMapper.insert(wageEarner);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }
}
