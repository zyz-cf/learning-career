package com.zyz.basic.exercises.keyword;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile关键字
 *
 * @author 张易筑
 * @date 2023/2/23-14:20 Thursday
 */
public class VolatileKeyword {

    static volatile boolean flag = true;

    /**
     * 验证多线程可见性
     *
     * @author 张易筑
     * @date 2023-02-24 10:16:19
     */
    public static void verifyVisibility() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t coming in...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            flag = false;
        }, "Thread 1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t coming in...");
            while (flag) {

            }
            System.out.println(Thread.currentThread().getName() + "\t flag be set false. program stop!");
        }, "Thread 2").start();
    }

    /**
     * 验证原子性
     *
     * @author 张易筑
     * @date 2023-02-24 11:01:22
     */
    public static void verifyAtomicity() {
        NumberPlus numberPlus = new NumberPlus();
        // 启动10个线程，每个线程将numberPlus的num值加1000次，那么理论上number值最终是10000
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    numberPlus.add();
                }
            }, StrUtil.concat(true, "Thread", Convert.toStr(i))).start();
        }

        // 程序运行时，模型会有主线程和守护线程。如果超过２个，那就说明上面的２０个线程还有没执行完的，就需要等待
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(StrUtil.concat(true
                , "num值加了10000次，此时number的实际值是：" + numberPlus.num));
        System.out.println(StrUtil.concat(true
                , "atomicNum值加了10000次，此时atomicInteger的实际值是：" + numberPlus.atomicNum));
    }

    public static void main(String[] args) {
        // VolatileKeyword.verifyVisibility();
        VolatileKeyword.verifyAtomicity();
    }
}

class NumberPlus {
    // volatile不保证原子性
    volatile int num;

    // Atomic保证原子性
    AtomicInteger atomicNum = new AtomicInteger();

    public void add() {
        num++;
        atomicNum.getAndIncrement();
    }
}
