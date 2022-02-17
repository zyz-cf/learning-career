package com.zyz.basic.exercises.juc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 *
 * @author 张易筑
 * @date 2022/2/16-8:42 星期三
 */
@SpringBootTest
public class DeadLockTest {

    static Object a = new Object();
    static Object b = new Object();

    @Test
    public void testDeadLock() {
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
