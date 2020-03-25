package com.mp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.mp.biz.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * 查询所有
     */
    @Test
    public void select(){
        List<User> users = userMapper.selectList(null);
        Assert.assertEquals(5,5);
        users.forEach(System.out::println);
    }

    @Test
    public void testCollectionSelect(){

        List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
    }


    @Test
    public void testMapSelect(){

        Map map = new HashMap();
        map.put("name","临江仙");

        List users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testChainSelect(){
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        userLambdaQueryWrapper.eq(User::getName,"鹊桥仙");
        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
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
        userMapper.insert(new User("江城子",39,"slq@163.com",1L, LocalDateTime.now()));

    }

}
