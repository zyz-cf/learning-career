package com.zyz.design.pattern;

import com.zyz.design.pattern.creational.singleton.CASSingleton;
import com.zyz.design.pattern.creational.singleton.StaticInnerClassSingleton;
import com.zyz.design.pattern.creational.singleton.hungry.HungrySimpleSingleton;
import com.zyz.design.pattern.creational.singleton.hungry.HungryStaticCodeBlockSingleton;
import com.zyz.design.pattern.creational.singleton.lazy.LazyDCLSingleton;
import com.zyz.design.pattern.creational.singleton.lazy.LazySimpleSingleton;
import com.zyz.design.pattern.creational.singleton.lazy.LazySynCodeBlockSingleton;
import com.zyz.design.pattern.creational.singleton.lazy.LazySynMethodSingleton;
import org.junit.jupiter.api.Test;

public class DesignPatternApplicationTests {

    /**
     * 饿汉式-普通单例模式多线程下安全性测试
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

    /**
     * 饿汉式-静态代码块单例模式多线程下安全性测试
     *
     * @author 张易筑
     * @date 2023-02-27 15:33:50
     */
    @Test
    public void hungryStaticCodeBlockSingletonSafetyTest() {
        Runnable staticCodeBlockSingletonTask = () -> {
            HungryStaticCodeBlockSingleton staticCodeBlockSingleton = HungryStaticCodeBlockSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t => \t" + staticCodeBlockSingleton.hashCode());
        };
        for (int i = 1; i <= 1000; i++) {
            new Thread(staticCodeBlockSingletonTask, "Thread" + i).start();
        }
    }

    /**
     * 懒汉式-普通单例模式多线程下安全性测试
     *
     * @author 张易筑
     * @date 2023-02-20 11:20:15
     */
    @Test
    public void lazySimpleSingletonSafetyTest() {
        Runnable simpleSingletonTask = () -> {
            LazySimpleSingleton simpleSingleton = LazySimpleSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t => \t" + simpleSingleton.hashCode());
        };
        for (int i = 0; i <= 1000; i++) {
            new Thread(simpleSingletonTask, "Thread" + i).start();
        }
    }

    /**
     * 饿汉式-同步方法单例模式多线程下的安全性测试
     *
     * @author 张易筑
     * @date 2023-02-27 15:56:27
     */
    @Test
    public void lazySynMethodSingletonSafetyTest() {
        Runnable synMethodSingletonTask = () -> {
            LazySynMethodSingleton synMethodSingleton = LazySynMethodSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t => \t" + synMethodSingleton.hashCode());
        };
        for (int i = 1; i <= 1000; i++) {
            new Thread(synMethodSingletonTask, "Thread" + i).start();
        }
    }

    /**
     * 饿汉式-同步代码块单例模式多线程下的安全性测试
     *
     * @author 张易筑
     * @date 2023-02-27 16:19:48
     */
    @Test
    public void lazySynCodeBlockSingletonSafetyTest() {
        Runnable synCodeBlockSingletonTask = () -> {
            LazySynCodeBlockSingleton synCodeBlockSingleton = LazySynCodeBlockSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t => \t" + synCodeBlockSingleton.hashCode());
        };
        for (int i = 1; i <= 1000; i++) {
            new Thread(synCodeBlockSingletonTask, "Thread" + i).start();
        }
    }

    /**
     * 饿汉式-DCL单例模式多线程下的安全性测试
     *
     * @author 张易筑
     * @date 2023-02-27 16:19:48
     */
    @Test
    public void lazyDCLSingletonSafetyTest() {
        Runnable dclBlockSingletonTask = () -> {
            LazyDCLSingleton dclSingleton = LazyDCLSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t => \t" + dclSingleton.hashCode());
        };
        for (int i = 1; i <= 1000; i++) {
            new Thread(dclBlockSingletonTask, "Thread" + i).start();
        }
    }

    /**
     * 静态内部类-单例模式多线程下的安全性测试
     *
     * @author 张易筑
     * @date 2023-02-27 16:49:25
     */
    @Test
    public void staticInnerClassSingletonSafetyTest() {
        Runnable staticInnerClassSingletonTask = () -> {
            StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t => \t" + staticInnerClassSingleton.hashCode());
        };
        for (int i = 1; i <= 1000; i++) {
            new Thread(staticInnerClassSingletonTask, "Thread" + i).start();
        }
    }

    /**
     * CAS-单例模式多线程下的安全性测试
     *
     * @author 张易筑
     * @date 2023-02-27 16:49:25
     */
    @Test
    public void casSingletonSafetyTest() {
        Runnable casSingletonTask = () -> {
            CASSingleton casSingleton = CASSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t => \t" + casSingleton.hashCode());
        };
        for (int i = 1; i <= 1000; i++) {
            new Thread(casSingletonTask, "Thread" + i).start();
        }
    }

}
