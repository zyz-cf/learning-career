package com.zyz.basic.exercises.service;

/**
 * 排序服务
 *
 * @author 张易筑
 * @date 2022/1/17-14:35 星期一
 */
@FunctionalInterface
public interface OrderService {

    /**
     * 添加order
     *
     * @author 张易筑
     * @date 2022-01-18 08:55:20
     */
    void addOrder();

    /**
     * 获取order
     *
     * @author 张易筑
     * @date 2022-01-18 08:56:20
     */
    default void getOrder() {
        System.out.println("I am order");
    }

    /**
     * 打印order
     *
     * @author 张易筑
     * @date 2022-01-19 13:34:11
     */
    default void printOrder() {
        System.out.println("I am print order");
    }
}
