package com.zyz.design.pattern.creational.singleton.lazy;

/**
 * 懒汉式-同步代码块单例模式
 * 线程不安全：因为指令重排问题，会产生空指针异常，引入volatile
 *
 * @author 张易筑
 * @date 2023/2/27-16:04 Monday
 */
public class LazySynCodeBlockSingleton {

    // 1、私有成员变量
    private static LazySynCodeBlockSingleton singleton;

    // 2、私有构造方法
    private LazySynCodeBlockSingleton() {
        System.out.println(Thread.currentThread().getName() + "\t 执行构造方法LazySynCodeBlockSingleton()");
    }

    // 3、公有方法获取实例
    public static LazySynCodeBlockSingleton getInstance() {
        if (singleton == null) {
            synchronized (LazySynCodeBlockSingleton.class) {
                if (singleton == null) {
                    singleton = new LazySynCodeBlockSingleton();
                }
            }
        }
        return singleton;
    }
}
