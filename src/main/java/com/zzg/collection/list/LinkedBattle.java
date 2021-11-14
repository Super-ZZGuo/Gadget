package com.zzg.collection.list;/*
@date 2021/11/14 - 10:01 上午
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 测试10000个随机位置插入
 * 数组随机位置插入10000次耗时：11
 * 链表随机位置插入10000次耗时：183
 */
public class LinkedBattle {
    private static final int COUNT = 1000000;

    static List<Integer> fillList(List<Integer> list) {
        for (int i = 0; i < COUNT; i++) {
            //将list填满，假装我们在数据库里得到这么多数据
            list.add(i);
        }
        return list;
    }
    static void randomAdd(List<Integer> list, String listType) {
        long t1 = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {

            list.add(ThreadLocalRandom.current().nextInt(0,COUNT), i);
        }

        long t2 = System.currentTimeMillis();
        System.out.println(listType +"随机位置插入" + COUNT + "次耗时：" + (t2-t1));
    }



    public static void main(String[] args) {

        randomAdd(fillList(new ArrayList<>()), "数组");

//        randomAdd(fillList(new LinkedList<>()), "链表");

    }
}