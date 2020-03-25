package com.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2020/3/25 15:12
 */

@SpringBootApplication
@MapperScan("com.mp")
public class MpApplication {

    public static void main(String[] args) {

        SpringApplication.run(MpApplication.class,args);

        System.out.println("============hello mp ===========");
    }
}
