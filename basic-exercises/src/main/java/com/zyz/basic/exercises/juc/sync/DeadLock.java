package com.zyz.basic.exercises.juc.sync;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 *
 * @author 张易筑
 * @date 2022/2/16-11:08 星期三
 */
public class DeadLock {

    static Object a = new Object();
    static Object b = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "获得锁a，试图获取锁b");

                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "获得锁b");
                }
            }
        }, "A线程").start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "获得锁b，试图获取锁a");

                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "获得锁a");
                }
            }
        }, "B线程").start();
    }
}
