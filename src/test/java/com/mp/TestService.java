package com.mp;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.biz.Player;
import com.mp.service.PlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * mp的服务方法测试
 * @date 2020/5/20 15:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestService {

    @Autowired
    PlayerService playerService;

    @Test
    public void testGet(){

        Player player = playerService.getById(1);

        System.out.println(player);
    }


    /**
     * 不带条件的分页查询,对象的方式返回
     * [Player(id=1, name=临江仙, age=35, email=linjiangxian@163.com, managerId=0, createTime=2020-03-30T13:44:01, updateTime=2020-03-30T13:44:01, version=1, deleted=0),
     * Player(id=2, name=鹊桥仙, age=30, email=queqiaoxian@163.com, managerId=0, createTime=2020-03-30T13:46, updateTime=2020-03-30T13:46, version=1, deleted=0),
     * Player(id=4, name=宋江, age=60, email=songjiamng@163.com, managerId=1, createTime=2020-03-30T13:56:46, updateTime=2020-03-30T13:56:46, version=1, deleted=0)]
     */
    @Test
    public void testpage1(){

        Page<Player> objectPage = new Page<>();
        objectPage.setSize(3);

        Page<Player> pages = playerService.page(objectPage);

        System.out.println("result: " + pages.getRecords());
    }


    /**
     * 带查询条件分页查询
     *
     */
    @Test
    public void testpage2(){

        Page<Player> objectPage = new Page<>();
        objectPage.setSize(3);

        Page<Player> pages = playerService.page(objectPage, Wrappers.<Player>lambdaQuery().eq(Player::getManagerId, 1));

        System.out.println("result: " + pages.getRecords());
    }



    /**
     * map数组的方式返回
     * [{update_time=2020-03-30 13:44:01.0, deleted=0, create_time=2020-03-30 13:44:01.0, manager_id=0, name=临江仙, id=1, version=1, age=35, email=linjiangxian@163.com},
     *  {update_time=2020-03-30 13:46:00.0, deleted=0, create_time=2020-03-30 13:46:00.0, manager_id=0, name=鹊桥仙, id=2, version=1, age=30, email=queqiaoxian@163.com},
     *  {update_time=2020-03-30 13:56:46.0, deleted=0, create_time=2020-03-30 13:56:46.0, manager_id=1, name=宋江, id=4, version=1, age=60, email=songjiamng@163.com}]
     */
    @Test
    public void testpage3(){

        Page objectPage = new Page<>();
        objectPage.setSize(3);

        Map<String, Object> map = new HashMap<>();

        Page page = playerService.pageMaps(objectPage);

        System.out.println("result: " + page.getRecords());
    }

}
