package com.mp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.mp.biz.Player;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2020/3/30 13:36
 */
public interface PlayerMapper extends BaseMapper<Player> {

    @Select("select * from player where deleted = 1")
    List<Player> mySelectAllDeletePlayers();


    @Select("select * from player ${ew.customSqlSegment}")
    List<Player> mySelectPlayers(@Param(Constants.WRAPPER)Wrapper<Player> wrapper);


}
