package com.zyz.design.pattern.creational.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS-单例模式
 * CAS是乐观锁，相比较，更轻量级;CAS存在忙等的问题，可能会造成CPU资源的浪费
 * @author 张易筑
 * @date 2023/2/27-16:53 Monday
 */
public class CASSingleton {

    // 1、私有成员变量
    private static final AtomicReference<CASSingleton> SINGLETON = new AtomicReference<>();

    // 2、私有构造方法
    private CASSingleton() {}

    // 3、公有方法获取实例
    public static CASSingleton getInstance() {
        CASSingleton singleton = SINGLETON.get();
        if (null == singleton) {
            SINGLETON.compareAndSet(null, new CASSingleton());
        }
        return SINGLETON.get();
    }

}
