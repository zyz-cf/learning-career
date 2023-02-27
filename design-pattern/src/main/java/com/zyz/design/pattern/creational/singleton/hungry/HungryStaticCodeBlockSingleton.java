package com.zyz.design.pattern.creational.singleton.hungry;

/**
 * 饿汉式-静态代码块单例模式,线程安全
 *
 * @author 张易筑
 * @date 2023/2/27-15:29 Monday
 */
public class HungryStaticCodeBlockSingleton {

    // 1、私有成员变量
    private static HungryStaticCodeBlockSingleton singleton;

    static {
        singleton = new HungryStaticCodeBlockSingleton();
    }

    // 2、私有构造方法
    private HungryStaticCodeBlockSingleton() {}

    // 3、公有方法获取实例
    public static HungryStaticCodeBlockSingleton getInstance() {
        return singleton;
    }

}
