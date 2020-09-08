package com.mp.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mp.PlayerMapper;
import com.mp.biz.Player;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2020/3/30 13:36
 */
@Service
public class PlayerService extends ServiceImpl<PlayerMapper, Player> {


    /**
     * 根据用户名称查询
     * @param name
     * @return
     */
    public Player seleltByName(String name){

        return this.getOne(Wrappers.<Player>lambdaQuery().eq(Player::getName,name));
    }
}
