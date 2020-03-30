package com.mp;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.biz.User;
import com.mp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * AR模式测试类
 * @date 2020/3/29 22:06
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ARTest {

    @Autowired
    UserService userService;


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


    @Test
    public void testUserService1(){

        User user = userService.getById(18);

        System.out.println(user);
    }


    @Test
    public void testUserService2(){

        System.out.println(userService.count());
    }


    @Test
    public void testUserService3(){

        System.out.println(userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getName,"宋江")));
    }

}
