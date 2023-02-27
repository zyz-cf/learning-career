package com.zyz.design.pattern.creational.singleton.lazy;

/**
 * 懒汉式-DoubleCheckLock单例模式
 *
 * @author 张易筑
 * @date 2023/2/27-15:54 Monday
 */
public class LazyDCLSingleton {

    // 1、私有成员变量
    private static volatile LazyDCLSingleton singleton;

    // 2、私有构造方法
    private LazyDCLSingleton() {}

    // 3、公有方法获取实例
    public static LazyDCLSingleton getInstance() {
        if (singleton == null) {
            synchronized (LazyDCLSingleton.class) {
                if (singleton == null) {
                    singleton = new LazyDCLSingleton();
                }
            }
        }
        return singleton;
    }
}
