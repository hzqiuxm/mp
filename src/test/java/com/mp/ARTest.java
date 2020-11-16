package com.mp;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.biz.BuDui;
import com.mp.biz.User;
import com.mp.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * AR模式测试类
 * @date 2020/3/29 22:06
 */
@SpringBootTest
public class ARTest {

    @Autowired
    UserService userService;


    @DisplayName("AR插入模式")
    @Test
    public void testArInsert(){

        User user = new User();

        user.setName("鲁智深");
        user.setAge(36);
        user.setEmail("luzihshen@163.com");
        user.setManagerId(1L);
        user.setCreateTime(LocalDateTime.now());

        user.insert();
    }


    /**
     * InsertOrUpdate,没有设置主键的话就直接插入，有主键数据库不存在也是插入，存在则是更新
     */
    @DisplayName("基于AR的InsertOrUpdate")
    @Test
    public void testArInsertOrUpdate(){

        User user = new User();

        user.setId(18L);
        user.setName("卢俊义");
        user.setAge(47);
        user.setEmail("lujunyi@163.com");
        user.setManagerId(1L);
        user.setCreateTime(LocalDateTime.now());

        user.insertOrUpdate();
    }


    @DisplayName("根据ID查询服务测试")
    @Test
    public void testUserService1(){

        User user = userService.getById(1);

        System.out.println(user);


    }


    @DisplayName("统计查询服务测试")
    @Test
    public void testUserService2(){

        System.out.println(userService.count());
    }


    @DisplayName("getOne服务查询测试")
    @Test
    public void testUserService3(){

        System.out.println(userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getName,"宋江")));
    }


    /**
     * 数据库字段json格式的测试，budui是一个json类型字段，对应实体类类型String
     * {"type": "步兵", "count": 30, "level": "高阶"}
     */
    @DisplayName("json格式查询与对象转换")
    @Test
    public void testUserJson(){

        User user = userService.getById(1);

        System.out.println("user = " + user);

        Object json = JSON.toJSON(user.getBudui());

        System.out.println("user = " + json);

        BuDui buDui = JSON.parseObject(user.getBudui(), BuDui.class);

        System.out.println("buDui = " + buDui);

    }

}
