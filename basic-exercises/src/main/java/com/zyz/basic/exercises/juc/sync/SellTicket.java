package com.zyz.basic.exercises.juc.sync;

import cn.hutool.core.convert.Convert;

/**
 * 票
 *
 * @author 张易筑
 * @date 2022/2/21-13:57 星期一
 */
class Ticket {

    private Integer ticketNumber = 10000;

    /**
     * 卖票
     *
     * @author 张易筑
     * @date 2022-02-21 14:09:16
     */
    public synchronized void sell() throws InterruptedException {
        while (ticketNumber > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出第 " + (ticketNumber--) + " 张票,还剩余" + ticketNumber + "张");
        }
        /*while (ticketNumber > 0) {
            synchronized (this) {
                if (ticketNumber > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出第 " + (ticketNumber--) + " 张票,还剩余" + ticketNumber + "张");
                } else {
                    System.out.println("票卖完了...");
                    break;
                }
            }
        }*/
    }
}

/**
 * 卖票
 *
 * @author 张易筑
 * @date 2022-02-21 13:09:59
 */
public class SellTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        /*hreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2
                , 5
                , 10
                , TimeUnit.MILLISECONDS
                , new ArrayBlockingQueue<>(5)
                , Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.AbortPolicy());
        for (int i = 1; i <= 5; i++) {
            Runnable runnable = () -> {
                try {
                    for (int j = 1; j <= 20 ; j++) {
                        ticket.sell();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            threadPoolExecutor.execute(runnable);
        }
        threadPoolExecutor.shutdown();*/
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 100 ; j++) {
                        ticket.sell();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "窗口" + Convert.toStr(i)).start();
        }
    }
}
