package com.mp;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.biz.Player;
import com.mp.service.PlayerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * 进阶部分测试示例
 * @date 2020/3/30 13:38
 */
@SpringBootTest
public class TestPlayer {

    @Autowired
    PlayerService playerService;
    @Autowired
    PlayerMapper playerMapper;



    @DisplayName("单值插入")
    @Test
    public void testInsert(){

        Player player = new Player("李逵", 40, "likui@163.com", 1);

        player.insert();
    }


    @DisplayName("批量插入")
    @Test
    public void testInsertService(){

        Player player1 = new Player("宋江", 60, "songjiamng@163.com", 1);
        Player player2 = new Player("卢俊义", 50, "lujingyi@163.com", 1);
        Player player3 = new Player("花荣", 42, "huaorng@163.com", 1);
        Player player4 = new Player("燕青", 30, "yanqing@163.com", 1);

        Player player5 = new Player("扈三娘", 30, "hushanniang@163.com", 2);
        Player player6 = new Player("孙二娘", 40, "sunerniang@163.com", 2);
        Player player7 = new Player("杜十娘", 35, "dushiniang@163.com", 2);
        Player player8 = new Player("孙尚香", 20, "sunshangxiang@163.com", 2);
        Player player9 = new Player("马云禄", 24, "mayunlu@163.com", 2);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        players.add(player7);
        players.add(player8);
        players.add(player9);


        playerService.saveBatch(players);
    }


    @DisplayName("逻辑删除示例")
    @Test
    public void testLogicDelete(){

        int rows = playerMapper.deleteById(3);

        System.out.println("影响行数：" + rows);
    }


    @DisplayName("查询将排除逻辑删除的数据")
    @Test
    public void testSelectLogicDelete(){

        List<Player> players = playerMapper.selectList(Wrappers.<Player>lambdaQuery().eq(Player::getManagerId, 1));
//        List<Player> players = playerMapper.selectList(null);

        players.forEach(System.out::println);

    }


    @DisplayName("查询逻辑删除的数据")
    @Test
    public void testSelectLogicDelete2(){

        List<Player> players = playerMapper.mySelectAllDeletePlayers();

        players.forEach(System.out::println);

    }

}
