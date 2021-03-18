package com.mp.biz;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * Copyright © 2021年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2021/3/18 20:43
 */
@Data
public class Address {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long userId;
    private String province;
    private String city;
    private String area;
    private String street;
    private String location;
    private String isDefault;
}
