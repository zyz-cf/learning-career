package com.zyz.basic.exercises.juc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 线程创建方式
 *
 * @author 张易筑
 * @date 2022/2/17-17:16 星期四
 */
@SpringBootTest
public class CreateThreadTest {

    @Test
    public void testCallableCreateThread() {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 100);
        new Thread(futureTask, "我是callable").start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        FutureTask<Integer> futureTask1 = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "你好啊");
            TimeUnit.SECONDS.sleep(2);
            return 100;
        });
        new Thread(futureTask1, "callable").start();
        try {
            System.out.println(futureTask1.get());
            System.out.println(futureTask1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
