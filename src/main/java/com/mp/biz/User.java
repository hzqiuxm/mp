package com.mp.biz;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2020/3/25 15:17
 */
@Data
@TableName("user")
public class User extends Model<User> {


    @TableId(type = IdType.AUTO)
    private Long id ;
    private String name;
    private Integer age;
//    @TableField(select = false) 字段还是返回，值为null
    private String email;
    private Long managerId;
    private String budui;
    private LocalDateTime createTime;
    @TableField(exist = false)
    private List<Address> addresses;

    public User(String name, Integer age, String email, Long managerId, LocalDateTime createTime) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.managerId = managerId;
        this.createTime = createTime;
    }

    public User() {
    }
}
