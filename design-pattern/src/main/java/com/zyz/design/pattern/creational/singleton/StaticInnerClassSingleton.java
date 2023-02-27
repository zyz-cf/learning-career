package com.zyz.design.pattern.creational.singleton;

/**
 * 静态内部类-单例模式
 * 线程安全：主动调用时才实例化，延迟加载效率高
 * Singleton类被装载时并不会立即实例化，而是在需要实例化时
 * 调用getInstance方法，才会加载静态内部类InnerSingleton类，从而完成Singleton的实例化。
 * 类的静态属性只会在第一次加载类的时候初始化，同时类加载的过程又是线程互斥的，JVM帮助我们保证了线程安全。
 *
 * @author 张易筑
 * @date 2023/2/16-9:43 Thursday
 */
public class StaticInnerClassSingleton {

    // 1、静态内部类初始化实例
    private static class InnerClassSingleton {
        private static final StaticInnerClassSingleton SINGLETON = new StaticInnerClassSingleton();
    }

    // 2、私有构造方法
    private StaticInnerClassSingleton() {}

    // 3、公有方法获取实例
    public static StaticInnerClassSingleton getInstance() {
        return InnerClassSingleton.SINGLETON;
    }
}
