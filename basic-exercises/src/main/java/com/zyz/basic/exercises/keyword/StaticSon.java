package com.zyz.basic.exercises.keyword;

/**
 * 儿子
 *
 * @author 张易筑
 * @date 2023/2/22-16:19 Wednesday
 */
public class StaticSon extends StaticFather {

    static {
        System.out.println("子类静态代码块");
    }

    static {
        System.out.println("子类静态代码块1");
    }

    {
        System.out.println("子类普通代码块");
    }

    {
        System.out.println("子类普通代码块1");
    }

    StaticSon() {
        super();
        System.out.println("子类构造方法");
    }

    public static void main(String[] args) {
        StaticSon s1 = new StaticSon();
        System.out.println("====================================");
        StaticSon s2 = new StaticSon();
    }
}
