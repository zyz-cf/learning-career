package com.zyz.basic.exercises.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 并发之定制化通知
 *
 * @author 张易筑
 * @date 2022/2/15-16:15 星期二
 */
public class CustomizedNotice {

    private Integer flag = 1;
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println("我是：" + Thread.currentThread().getName() + "，第" + i + "次打印" + "，第" + loop + "轮");
            }

            flag = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println("我是：" + Thread.currentThread().getName() + "，第" + i + "次打印" + "，第" + loop + "轮");
            }

            flag = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println("我是：" + Thread.currentThread().getName() + "，第" + i + "次打印" + "，第" + loop + "轮");
            }

            flag = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }

}
