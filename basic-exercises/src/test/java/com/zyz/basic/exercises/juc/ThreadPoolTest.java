package com.zyz.basic.exercises.juc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

/**
 * 线程池测试
 *
 * @author 张易筑
 * @date 2022/2/21-10:33 星期一
 */
@SpringBootTest
public class ThreadPoolTest {

    @Test
    public void testThreadPool() {

        // 创建单核心的线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(() -> System.out.println("Hello singleThreadExecutor..." + Thread.currentThread().getName()));
        singleThreadExecutor.execute(() -> System.out.println("Hello singleThreadExecutor..." + Thread.currentThread().getName()));

        // 创建固定核心数的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        fixedThreadPool.execute(() -> System.out.println("Hello fixedThreadPool..." + Thread.currentThread().getName()));
        fixedThreadPool.execute(() -> System.out.println("Hello fixedThreadPool..." + Thread.currentThread().getName()));
        fixedThreadPool.execute(() -> System.out.println("Hello fixedThreadPool..." + Thread.currentThread().getName()));
        fixedThreadPool.execute(() -> System.out.println("Hello fixedThreadPool..." + Thread.currentThread().getName()));
        fixedThreadPool.shutdown();

        // 创建一个按照计划规定执行的线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
        scheduledThreadPool.schedule(() -> System.out.println("Hello scheduledThreadPool..." + Thread.currentThread().getName()), 2L, TimeUnit.SECONDS);
        scheduledThreadPool.shutdown();

        // 创建一个自动增长的线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        newCachedThreadPool.execute(() -> System.out.println("Hello newCachedThreadPool..." + Thread.currentThread().getName()));
        newCachedThreadPool.execute(() -> System.out.println("Hello newCachedThreadPool..." + Thread.currentThread().getName()));
        newCachedThreadPool.execute(() -> System.out.println("Hello newCachedThreadPool..." + Thread.currentThread().getName()));
        newCachedThreadPool.execute(() -> System.out.println("Hello newCachedThreadPool..." + Thread.currentThread().getName()));
        newCachedThreadPool.execute(() -> System.out.println("Hello newCachedThreadPool..." + Thread.currentThread().getName()));
        newCachedThreadPool.execute(() -> System.out.println("Hello newCachedThreadPool..." + Thread.currentThread().getName()));
        newCachedThreadPool.shutdown();

        // 创建一个具有抢占式操作的线程池
        ExecutorService newWorkStealingPool = Executors.newWorkStealingPool(2);
        newWorkStealingPool.execute(() -> System.out.println("Hello newWorkStealingPool..." + Thread.currentThread().getName()));
        newWorkStealingPool.execute(() -> System.out.println("Hello newWorkStealingPool..." + Thread.currentThread().getName()));
        newWorkStealingPool.shutdown();

        // 自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2
                , 5
                , 5
                , TimeUnit.SECONDS
                , new LinkedBlockingQueue<Runnable>(10)
                , Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> System.out.println("Hello threadPoolExecutor..." + Thread.currentThread().getName()));
        }
    }
}
