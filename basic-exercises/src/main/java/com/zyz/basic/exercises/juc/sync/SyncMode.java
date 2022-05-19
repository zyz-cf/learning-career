package com.zyz.basic.exercises.juc.sync;

import java.util.concurrent.TimeUnit;

/**
 * 八种锁
 *
 * @author 张易筑
 * @date 2022/2/22-9:09 星期二
 */
public class SyncMode {

    /**
     * 1、两个锁方法、同一个对象。（是同一把锁），main方法中线程谁先获得执行权谁先执行。因为synchronized锁的是phone对象
     * 2、普通方法和锁方法，先执行普通方法
     * 3、两个对象，两个锁方法。（两把不同锁），main方法中线程谁先获得执行权谁先执行。
     * 4、两个static 锁方法，锁的是类对象
     */
    public static void main(String[] args) throws InterruptedException {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                Phone.sendMsg();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        TimeUnit.SECONDS.sleep(1L);

        new Thread(() -> {
            // phone.call();
            // phone.sayHello();
            Phone.call();
        }, "B").start();
    }
}

class Phone {

    public static synchronized void sendMsg() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2L);
        System.out.println("=> Send Message...");
    }

    public static synchronized void call() {
        System.out.println("=> Call...");
    }

    public void sayHello() {
        System.out.println("=> Say Hello");
    }
}