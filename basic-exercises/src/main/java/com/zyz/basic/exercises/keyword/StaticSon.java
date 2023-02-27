package com.zyz.basic.exercises.keyword;

/**
 * 儿子
 * 父静态代码块>子静态代码块>父普通代码块>父构造类>子普通代码块>子构造类
 * 多个代码块按顺序执行，再次实例化对象，父子类的静态代码块都将不会再执行
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
