package com.zyz.basic.exercises.juc;

import cn.hutool.core.convert.Convert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

/**
 * 多线程辅助工具类
 *
 * @author 张易筑
 * @date 2022/2/17-9:37 星期四
 */
@SpringBootTest
public class AuxiliaryTest {

    // CountDownLatch类似于10人找了一个代购，代购收齐了10个客户的钱才买票出国购物
    // CyclicBarrier类似10个拼团购物，人齐了之后开团了，这10个自己买自己的哈

    /**
     * CountDownLatch倒计时使用场景：某线程需要等待其他几个线程都执行过后才能继续执行
     * 例子：某工地一共有十个人,包工头要等十个人都下班班以后,才可以关工厂门
     *
     * @author 张易筑
     * @date 2022-02-17 09:53:11
     */
    @Test
    public void countDownLatchTest() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        System.out.println("包工头在监工中......");
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "离开工地");
                    TimeUnit.SECONDS.sleep(1);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "搬砖工" + i).start();
        }
        try {
            countDownLatch.await();
            System.out.println("包工头关闭厂门......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * CyclicBarrier循环栅栏：所有线程在其他线程没有准备好之前都在被阻塞中,等到所有线程都准备好了才继续执行
     * 例子：十个赛道的运动员准备好后，裁判宣布开始后，运动员们开始比赛
     *
     * @author 张易筑
     * @date 2022-02-17 13:23:59
     */
    @Test
    public void cyclicBarrierTest() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println("开始疯狂输出吧，猛男美女们......");
        });

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "号猛男美女开始准备!");
                    System.out.println(Thread.currentThread().getName() + "号猛男美女准备好了!");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "号猛男美女开始疯狂输出!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, Convert.toStr(i)).start();
        }
    }

    /**
     * Semaphore信号量：控制同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可
     * 6辆车，3个停车位，已获得车位的车离开后，保证未获得车位的车都有位置停
     * @author 张易筑
     * @date 2022-02-17 14:22:55
     */
    @Test
    public void semaphoreTest() {
        Semaphore semaphore = new Semaphore(3, false);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到了车位");

                    // 设置停车时间
                    // TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    Thread.sleep(1);

                    System.out.println(Thread.currentThread().getName() + "离开了车位......");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, Convert.toStr(i)).start();
        }
    }

}
