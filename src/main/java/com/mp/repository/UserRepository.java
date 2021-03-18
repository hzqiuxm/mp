package com.mp.repository;

import com.mp.biz.Address;
import com.mp.biz.User;

import java.util.List;

/**
 * Copyright © 2021年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2021/3/18 21:14
 */
public interface UserRepository {

    User getUserDetailInfo(Integer userId);

    List<Address> getAllAddress(Integer userId);
}
