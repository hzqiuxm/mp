package com.mp.biz;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import	java.time.LocalDateTime;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2020/3/25 15:17
 */
@Data
@TableName("user")
public class User {


    private Long id ;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    private LocalDateTime createTime;

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
