package com.mp.biz;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * mp高阶教程的实体类
 * @date 2020/3/30 13:31
 */
@Data
@TableName("player")
public class Player extends Model<Player> {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String email;
    private Integer managerId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer version;
    @TableLogic
    private Integer deleted;


    public Player(String name, int age, String email, int managerId) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.managerId = managerId;
    }

    public Player() {
    }

    public Player(Long id, String name, Integer age, String email, Integer managerId, LocalDateTime createTime, LocalDateTime updateTime, Integer version, Integer deleted) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.managerId = managerId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.version = version;
        this.deleted = deleted;
    }
}
