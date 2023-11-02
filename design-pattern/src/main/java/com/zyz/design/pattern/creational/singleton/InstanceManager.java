package com.zyz.design.pattern.creational.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器-单例模式
 * 在程序的初始，将多种单例类型注入到一个统一的管理类中，在使用时根据key获取对象对应类型的对象。
 * 这种方式使得我们可以管理多种类型的单例，并且在使用时可以通过统一的接口进行获取操作,
 * 降低了用户的使用成本，也对用户隐藏了具体实现，降低了耦合度。
 * @author 张易筑
 * @date 2023/2/27-17:34 Monday
 */
public class InstanceManager {

    // 1、私有容器
    private static final Map<String, Object> instanceMap = new ConcurrentHashMap<>();

    // 2、私有构造方法
    private InstanceManager() {}

    // 3、注册服务
    public static void registerService(String key, Object instance) {
        if (!instanceMap.containsKey(key)) {
            instanceMap.put(key, instance);
        }
    }

    // 4、获取注册服务
    public static Object getService(String key) {
        return instanceMap.get(key);
    }
}
