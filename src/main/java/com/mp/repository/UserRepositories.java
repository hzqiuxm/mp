package com.mp.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.AddressMapper;
import com.mp.UserMapper;
import com.mp.biz.Address;
import com.mp.biz.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Copyright © 2021年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * 用户聚合资源库
 * @date 2021/3/18 21:07
 */
@Component
public class UserRepositories implements UserRepository{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 获取用户详情
     * @param userId 用户编号
     * @return 用户聚合根
     */
    @Override
    public User getUserDetailInfo(Integer userId){
        User user = userMapper.selectById(userId);
        List<Address> addresses = addressMapper.selectList(Wrappers.<Address>lambdaQuery().eq(Address::getUserId, 1));
        user.setAddresses(addresses);
        return user;
    }

    @Override
    public List<Address> getAllAddress(Integer userId) {
        return addressMapper.selectList(Wrappers.<Address>lambdaQuery().eq(Address::getUserId, 1));
    }
}
