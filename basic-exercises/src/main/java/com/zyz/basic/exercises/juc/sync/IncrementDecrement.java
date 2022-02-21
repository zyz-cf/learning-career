package com.zyz.basic.exercises.juc.sync;

/**
 * 加1减1
 *
 * @author 张易筑
 * @date 2022/2/21-15:33 星期一
 */
class Calculate {
    private Integer number = 0;

    /**
     * 加1
     *
     * @author 张易筑
     * @date 2022-02-21 15:42:18
     */
    public synchronized void increment() throws InterruptedException {
        while (number != 0) {
            wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + " increment " + number);
        notifyAll();
    }

    /**
     * 减1
     *
     * @author 张易筑
     * @date 2022-02-21 15:42:37
     */
    public synchronized void decrement() throws InterruptedException {
        while (number != 1) {
            wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + " decrement " + number);
        notifyAll();
    }
}

/**
 * 加减
 *
 * @author 张易筑
 * @date 2022-02-21 15:12:43
 */
public class IncrementDecrement {

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    calculate.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "A").start();

            new Thread(() -> {
                try {
                    calculate.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "B").start();

            new Thread(() -> {
                try {
                    calculate.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "C").start();

            new Thread(() -> {
                try {
                    calculate.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "D").start();
        }
    }
}
