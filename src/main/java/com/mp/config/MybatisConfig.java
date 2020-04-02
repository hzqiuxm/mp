package com.mp.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2020/3/27 14:55
 */
@Configuration
public class MybatisConfig {


    /**
     * 物理分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){

        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        //默认注释掉了多租户模式下配置
        /*ArrayList<ISqlParser> iSqlParsers = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new TenantHandler() {

            *//**
             * 从缓存或数据库或请求中获取租户id，这里为了演示方便写死
             * @param where
             * @return
             *//*
            @Override
            public Expression getTenantId(boolean where) {
                return new LongValue(1);
            }


            *//**
             * 返回多租户的id，这里使用manager_id来模拟
             * @return
             *//*
            @Override
            public String getTenantIdColumn() {
                return "manager_id";
            }


            *//**
             * 过去掉不需要租户id的表
             * @param tableName
             * @return
             *//*
            @Override
            public boolean doTableFilter(String tableName) {

                if("role".equals(tableName)){
                    return true;
                }

                return false;
            }
        });


        iSqlParsers.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(iSqlParsers);*/

        return paginationInterceptor;
    }


    /**
     * 乐观锁插件
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){

        return  new OptimisticLockerInterceptor();
    }

}
