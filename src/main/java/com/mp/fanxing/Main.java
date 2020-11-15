package com.mp.fanxing;

import cn.hutool.core.util.StrUtil;

/**
 * Copyright © 2020年 mp. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2020/4/4 22:03
 */
public class Main {

    public static void main(String[] args) {

//        ArrayList<Dog> dogs1 = new ArrayList<>();
//
//        ArrayList<Animal> animals1 = new ArrayList<>();
//
//        List<Animal> list = new ArrayList<Animal>();
//
//        ArrayList<Dog> dogs = new ArrayList<Dog> ();
//
//        ArrayList<Animal> animals = dogs;
//
//        List<Dog> dogList = dogs;
//
//        ArrayList<Object> objects = new ArrayList<>();
//
//        List<Object> objList = objects;
//
//        ArrayList<Object> objs = new ArrayList<Dog>();


//        for (int i = 0; i < 100; i++) {
//            int nextInt = new Random().nextInt(2);
//            System.out.println(nextInt);
//        }


        System.out.println(getDescriptKey("获得{jika}宝物"));


    }

    public static String getDescriptKey(String description){

        int beginIndex = description.indexOf("{");
        int endIndex = description.indexOf("}");

        return StrUtil.sub(description,beginIndex+1,endIndex);

    }
}
