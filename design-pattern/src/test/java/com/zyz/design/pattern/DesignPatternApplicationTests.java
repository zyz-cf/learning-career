package com.zyz.design.pattern;

import com.zyz.design.pattern.creational.singleton.HungrySimpleSingleton;
import com.zyz.design.pattern.creational.singleton.LazySimpleSingleton;
import org.junit.jupiter.api.Test;

public class DesignPatternApplicationTests {

    /**
     * 懒汉式-普通单例多线程下安全性测试
     *
     * @author 张易筑
     * @date 2023-02-20 11:20:15
     */
    @Test
    public void lazySingletonThreadSafetyTest() {
        Runnable lazySimpleSingletonTask = () -> {
            LazySimpleSingleton simpleSingleton = LazySimpleSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t => \t" + simpleSingleton.hashCode());
        };
        for (int i = 0; i <= 1000; i++) {
            new Thread(lazySimpleSingletonTask, "Thread" + i).start();
        }
    }

    /**
     * 饿汉式-普通单例多线程下安全性测试
     *
     * @author 张易筑
     * @date 2023-02-20 11:19:17
     */
    @Test
    public void hungrySimpleSingletonSafetyTest() {
        Runnable hungrySimpleSingletonTask = () -> {
            HungrySimpleSingleton simpleSingleton = HungrySimpleSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t => \t" + simpleSingleton.hashCode());
        };
        for (int i = 0; i <= 1000; i++) {
            new Thread(hungrySimpleSingletonTask, "Thread" + i).start();
        }
    }

}
