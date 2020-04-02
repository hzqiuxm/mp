package com.mp.handle;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * 自定义字段填充处理器
 * @date 2020/3/31 9:39
 */
@Slf4j
@Component
public class FillFieldHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {

        log.info("start insert fill ....");
        this.setFieldValByName("fieldName","fieldVale",metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        log.info("start update fill ....");
        this.setFieldValByName("fieldName","fieldVale",metaObject);
    }
}
