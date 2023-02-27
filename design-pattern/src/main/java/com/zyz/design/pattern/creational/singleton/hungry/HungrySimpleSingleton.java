package com.zyz.design.pattern.creational.singleton.hungry;

/**
 * 饿汉式-简单单例模式
 * 因为instance是个静态变量，所以它会在类加载的时候完成实例化，不存在线程安全的问题。
 * 缺点是不管我们的程序会不会用到，它都会在程序启动之初进行初始化。
 *
 * @author 张易筑
 * @date 2023/2/15-16:51 Wednesday
 */
public class HungrySimpleSingleton {

    // 1、私有成员变量
    private static final HungrySimpleSingleton singleton = new HungrySimpleSingleton();

    // 2、私有构造方法
    private HungrySimpleSingleton() {}

    // 3、公有方法获取实例
    public static HungrySimpleSingleton getInstance() {
        return singleton;
    }
}
