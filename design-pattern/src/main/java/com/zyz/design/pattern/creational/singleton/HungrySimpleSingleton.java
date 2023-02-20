package com.zyz.design.pattern.creational.singleton;

/**
 * 饿汉式-简单单例模式
 *
 * @author 张易筑
 * @date 2023/2/15-16:51 Wednesday
 */
public class HungrySimpleSingleton {

    // 1、私有成员变量
    private static final HungrySimpleSingleton singleton = new HungrySimpleSingleton();

    // 2、私有构造方法
    private HungrySimpleSingleton() {}

    // 3、公有方法获取
    public static HungrySimpleSingleton getInstance() {
        return singleton;
    }
}
