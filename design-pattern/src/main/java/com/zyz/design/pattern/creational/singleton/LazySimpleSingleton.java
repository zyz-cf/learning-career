package com.zyz.design.pattern.creational.singleton;

/**
 * 懒汉式-简单单例模式
 *
 * @author 张易筑
 * @date 2023/2/15-16:34 Wednesday
 */
public class LazySimpleSingleton {

    // 1、私有成员变量
    private static LazySimpleSingleton singleton = null;

    // 2、私有构造方法
    private LazySimpleSingleton() {}

    // 3、公共获取实例方法
    public static LazySimpleSingleton getInstance() {
        // 多个线程同时调用，可能会创建多个对象
        if (singleton == null) {
            singleton = new LazySimpleSingleton();
        }
        return singleton;
    }

}
