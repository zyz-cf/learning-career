package com.zyz.design.pattern.creational.singleton;

/**
 * 枚举-单例模式
 * 线程安全: 解决了串化、单实例, 避免反序列化创建新的实例，很少使用
 *
 * @author 张易筑
 * @date 2023/2/27-17:10 Monday
 */
public enum EnumSingleton {

    INSTANCE;

    public void doAnything() {

    }
}
