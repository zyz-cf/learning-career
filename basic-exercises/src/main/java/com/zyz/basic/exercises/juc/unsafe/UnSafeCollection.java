package com.zyz.basic.exercises.juc.unsafe;

import cn.hutool.core.convert.Convert;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 线程不安全的集合类
 *
 * @author 张易筑
 * @date 2022/2/24-9:12 星期四
 */
public class UnSafeCollection {

    public static void main(String[] args) {
        // java.util.ConcurrentModificationException
        // List解决方案：
        //     1、List<String> list = new Vector<>();
        //     2、List<String> list = Collections.synchronizedList(new ArrayList<>());
        //     3、List<String> list = new CopyOnWriteArrayList<>();
        /*List<String> list = new ArrayList<>();
        for (int i = 1; i <= 20 ; i++) {
            new Thread(() -> {
                System.out.println(UUID.randomUUID().toString().substring(0, 6));
            }, Convert.toStr(i)).start();
        }*/

        // Set解决方案：
        //     1、Set<String> set = Collections.synchronizedSet(new HashSet<>());
        //     2、 Set<String> set = new CopyOnWriteArraySet<>();
        /*Set<String> set = new HashSet();
        for (int i = 1; i <= 20 ; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 6));
                System.out.println(set);
            }, Convert.toStr(i)).start();
        }*/

        // Map解决方案：Map<String, Object> map = new ConcurrentHashMap<>();
        Map<String, Object> map = new HashMap<>();
        for (int i = 1; i <= 20 ; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 6));
                System.out.println(map);
            }, Convert.toStr(i)).start();
        }


    }
}
