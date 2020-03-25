package com.mp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mp.biz.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2020/3/25 15:21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMp {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void select(){

        List<User> users = userMapper.selectList(null);

        Assert.assertEquals(5,5);
        users.forEach(System.out::println);
    }


    @Test
    public void getTimeCondition(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("name","临江仙")
                .between("create_time","2020-03-25 05:00:00","2020-03-26 04:59:59");

        User user = userMapper.selectOne(queryWrapper);

        System.out.println(user);

    }


    @Test
    public void createUser(){

        userMapper.insert(new User("水龙应",39,"slq@163.com",1L, LocalDateTime.now()));


    }

}
