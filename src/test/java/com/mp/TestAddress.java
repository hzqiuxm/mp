package com.mp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright © 2021年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2021/3/18 20:49
 */
@SpringBootTest
public class TestAddress {

    @Autowired
    private AddressMapper addressMapper;

    @DisplayName("查询address")
    @Test
    public void testMapSelect(){

        Map map = new HashMap();
        map.put("user_id",1L);

        List addresses = addressMapper.selectByMap(map);
        addresses.forEach(System.out::println);
    }
}
