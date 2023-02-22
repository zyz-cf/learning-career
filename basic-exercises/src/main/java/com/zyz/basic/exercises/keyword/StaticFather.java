package com.zyz.basic.exercises.keyword;

/**
 * 父亲
 *
 * @author 张易筑
 * @date 2023/2/22-16:19 Wednesday
 */
public class StaticFather {

    static {
        System.out.println("父类静态代码块");
    }

    static {
        System.out.println("父类静态代码块1");
    }

    {
        System.out.println("父类普通代码块");
    }

    {
        System.out.println("父类普通代码块1");
    }

    StaticFather() {
        System.out.println("父类构造方法");
    }
}
