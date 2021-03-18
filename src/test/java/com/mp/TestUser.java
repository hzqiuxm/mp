package com.mp;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.biz.Address;
import com.mp.biz.User;
import com.mp.repository.UserRepositories;
import com.mp.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Copyright © 2021年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2021/3/18 20:49
 */
@SpringBootTest
public class TestUser {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private UserRepository userRepositories;

    @DisplayName("查询用户详情")
    @Test
    public void testAllSelect(){
        User user = userMapper.selectById(1);
        List<Address> addresses = addressMapper.selectList(Wrappers.<Address>lambdaQuery().eq(Address::getUserId, 1));
        user.setAddresses(addresses);
        System.out.println(user);
    }

    @DisplayName("查询用户聚合")
    @Test
    public void testGetUserDetailInfo(){
        User userDetailInfo = userRepositories.getUserDetailInfo(1);
        System.out.println(userDetailInfo);
    }

    @DisplayName("查询用户的所有地址")
    @Test
    public void testGetAllAddress(){
        List<Address> allAddress = userRepositories.getAllAddress(1);
        allAddress.forEach(System.out::println);
    }
}
