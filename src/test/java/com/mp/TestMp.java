package com.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.biz.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2020/3/25 15:21
 */
@SpringBootTest
public class TestMp {

    @Autowired
    private UserMapper userMapper;



    @DisplayName("简单插入操作")
    @Test
    public void testInsert(){

        User user = new User();

        user.setName("蔡琴");
        user.setAge(18);
        user.setEmail("caiqing@163.com");
        user.setManagerId(1L);
        user.setCreateTime(LocalDateTime.now());

        userMapper.insert(user);
    }


    @DisplayName("查询所有记录")
    @Test
    public void testSelect(){
        List<User> users = userMapper.selectList(null);

        users.forEach(System.out::println);
    }


    @DisplayName("根据ID批量查询")
    @Test
    public void testCollectionSelect(){

        List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
    }


    @DisplayName("使用Map作为参数查询")
    @Test
    public void testMapSelect(){

        Map map = new HashMap();
        map.put("name","临江仙");

        List users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @DisplayName("lambda链式查询")
    @Test
    public void testChainSelect(){
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        userLambdaQueryWrapper.eq(User::getName,"临江仙").eq(User::getAge,35);
        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        users.forEach(System.out::println);

    }

    @DisplayName("时间日期查询")
    @Test
    public void getTimeCondition(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","临江仙")

                .between("create_time","2020-03-25 05:00:00","2020-03-26 04:59:59");

        User user = userMapper.selectOne(queryWrapper);

        System.out.println(user);

    }


    /**
     * 查找王姓，年龄大于25，创建时间在2020-03-25之前用户，根据id降序排序
     */
    @DisplayName("组合排序查询")
    @Test
    public void testSelectByWrapper1(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "王").le("create_time", LocalDateTime.of(2020, 03, 25,0,0,0))
                .orderByDesc("id");

        List<User> users = userMapper.selectList(queryWrapper);

        users.forEach(System.out::println);


    }


    @DisplayName("创建一个User")
    @Test
    public void createUser(){
        userMapper.insert(new User("江城子",39,"slq@163.com",1L, LocalDateTime.now()));

    }


    /**
     * 查找直属上级是鹊姓，创建时间在2019-2-14号的用户信息
     */
    @DisplayName("apply和insql的使用")
    @Test
    public void testApply(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}","2019-02-14")
                .inSql("manager_id","select id from user where name like '鹊%'");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


    /**
     * between的使用
     * 名字为王姓且(年龄大于20但小于40并且邮箱不为空)
     * name like '王%', age<40 or email !=null
     */
    @DisplayName("and()lambda表达式的使用")
    @Test
    public void testAndLamda1(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.likeRight("name","王")
                .and(wq->wq.lt("age",40).gt("age",20).isNotNull("email"));
//
//        queryWrapper.likeRight("name","王")
//                .between("age",20,40)
//                .isNotNull("email");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


    /**
     * between的使用
     * 名字为王姓或(年龄大于10但小于50并且邮箱不为空)
     * name like '王%', age<40 or email !=null
     */
    @DisplayName("or()lambda表达式的使用")
    @Test
    public void testAndLamda2(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.likeRight("name" , "王")
                .or(wq->wq.between("age",10,50))
                .isNotNull("email");

        //name LIKE ? OR (age BETWEEN ? AND ?) AND email IS NOT NULL
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


    /**
     * （年龄小于30或邮箱不为空）并且名字为王姓
     *  (age<30 or email!=null) and name like '王%'
     */
    @DisplayName("nested嵌套查询使用")
    @Test
    public void testchaxun1(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.nested(wq->wq.lt("age",30).or().isNotNull("email"))
                .likeRight("name","王");

        //(age < ? OR email IS NOT NULL) AND name LIKE ?
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


    /**
     * 年龄为 25,26,27,28,29
     */
    @DisplayName("in和limit使用")
    @Test
    public void testchaxun2(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.in("age",25,26,27,28,29).last("limit 1");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


    /**
     * select只返回指定字段,结构还是完整的，其它字段的值都是空（）
     * 两种思路，一种是指定要返回的，一种是排除不要返回的
     */
    @DisplayName("用select返回指定字段查询")
    @Test
    public void testSelect1(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select("name","email");
        queryWrapper.select(User.class,info->!info.getColumn().equals("create_time"));

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


    @DisplayName("带实体条件的构造器用法")
    @Test
    public void testSelectByWrapperEntity(){

        User whereUser = new User();
        whereUser.setName("临江仙");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(whereUser,"name,email");
//        queryWrapper.likeRight("name","王");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


    @DisplayName("map和Alleq的用法")
    @Test
    public void testAlleq(){

        Map map = new HashMap();
        map.put("name","临江仙");
        map.put("age",33);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(map);

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


    @DisplayName(" 多个eq条件查询")
    @Test
    public void testMoreEq(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","临江仙").eq("age",35);

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


    @DisplayName("SelectMap使用，只返回需要的字段结构")
    @Test
    public void testSelectMap(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age").likeRight("name","临");

        List<Map<String, Object>> users = userMapper.selectMaps(queryWrapper);
        users.forEach(System.out::println);
    }


    /**
     * 按照直属上级分组，查询每组的平均年龄、最大年龄、最小年龄，并且只取年龄总和小于500的组
     * select avg(age) avg_age,min(age) min_age,max(age) max_age from user
     * groupby manager_id having sum(age)<500
     */
    @DisplayName("分组查询")
    @Test
    public void testSelectMap2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("avg(age) avg_age","min(age) min_age","max(age) max_age")
                .groupBy("manager_id").having("sum(age)<{0}",500);

        List<Map<String, Object>> users = userMapper.selectMaps(queryWrapper);
        users.forEach(System.out::println);
    }

    @DisplayName("统计查询")
    @Test
    public void testCount(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","小");

        Integer integer = userMapper.selectCount(queryWrapper);

        System.out.println("总记录数有："+ integer);

    }

    @DisplayName("返回map结构简单的Lambda表达式查询")
    @Test
    public void testLamda(){

        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.like(User::getName,"阮");

        List<Map<String, Object>> users = userMapper.selectMaps(lambdaQuery);
        users.forEach(System.out::println);
    }


    @Test
    @DisplayName("返回List结构简单的Lambda表达式查询")
    public void testMySql(){

        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.like(User::getName,"阮");

        List<User> users = userMapper.selectAll(lambdaQuery);
        users.forEach(System.out::println);

    }


    @DisplayName("分页查询")
    @Test
    public void testSelectByPage1(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");


        Page<User> users = userMapper.selectPage(new Page<>(1, 5), queryWrapper);

        users.getRecords().forEach(System.out::println);

    }


    @DisplayName("根据Id主键来更新")
    @Test
    public void testUpdate1(){

        User user = new User();
        user.setId(12L);
        user.setAge(32);
        int rows = userMapper.updateById(user);

        assertEquals(1,rows);

    }


    /**
     * 更新名字代王的，年龄小于30岁，改成20
     */
    @DisplayName("使用updateWrapper构建where更新条件")
    @Test
    public void testUpdate2(){

        User user = new User();
        user.setAge(20);

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.likeRight("name","王").lt("age",30);

        int rows = userMapper.update(user,updateWrapper);

        assertEquals(2,rows);

    }


    /**
     * 和上一个测试用例作用一样，只是写法更优雅，不用传user对象了
     */
    @DisplayName("优雅.set使用updateWrapper构建where更新条件")
    @Test
    public void testUpdate3(){


        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.likeRight("name","王").lt("age",30).set("age",21);

        int rows = userMapper.update(null,updateWrapper);

        assertEquals(2,rows);

    }


    @DisplayName("LambdaUpdateChainWrapper方式链式更新")
    @Test
    public void testUpdate4(){

        boolean update = new LambdaUpdateChainWrapper<User>(userMapper).eq(User::getName, "王阳明").set(User::getAge, 50).update();

    }




}
