package com.zyz.design.pattern.creational.singleton.lazy;

/**
 * 懒汉式-同步方法单例模式
 * 线程安全：但synchronized锁住方法体，效率相对较低
 *
 * @author 张易筑
 * @date 2023/2/27-15:47 Monday
 */
public class LazySynMethodSingleton {

    // 1、私有成员变量
    private static LazySynMethodSingleton singleton;

    // 2、私有构造方法
    private LazySynMethodSingleton() {}

    // 3、公有方法获取实例
    public synchronized static LazySynMethodSingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySynMethodSingleton();
        }
        return singleton;
    }
}
