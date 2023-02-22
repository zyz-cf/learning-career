package com.zyz.basic.exercises.keyword;

import cn.hutool.core.util.ObjectUtil;

import java.util.Arrays;

/**
 * final关键字
 *
 * @author 张易筑
 * @date 2023/2/22-14:33 Wednesday
 */
public final class FinalKeyword extends ClassLoader {

    // 1、final修饰的类不能被继承，但可以有父类
    // 2、final修饰的方法不能被重写，但可以继承

    // 3、final修饰成员变量可以在申明的时候初始化
    final String keyword = "keyword";

    // 4、final修饰的成员变量可以在普通代码块中初始化
    final String codeBlockKeyword;

    {
        codeBlockKeyword = "codeBlockKeyword";
    }

    // 5、final修饰的成员变量可以在构造方法中初始化
    final String constructorKeyword;

    FinalKeyword(String constructorKeyword) {
        this.constructorKeyword = constructorKeyword;
    }

    // 6、static final修饰的成员变量只能在声明时候或静态代码块中初始化
    static final String staticCodeBlockKeyword;

    static {
        staticCodeBlockKeyword = "staticCodeBlockKeyword";
    }

    public void commonKeyword() {
        // 7、final修饰局部变量声明的时候可以不初始化，但是使用时必须初始化
        final String commonKeyword = "commonKeyword";
        if (ObjectUtil.isNull(commonKeyword)) {
            System.out.println("final修饰局部变量声明的时候可以不初始化，但是使用时必须初始化");
        }

        // 8、final修饰引用数据类型，引用变量所指向的对象（即该变量所存放的地址值）不能更改，但是该对象的内容（即地址值上存储的内容）可以更改
        final String[] commonKeywords = {"X", "Y", "Z"};
        commonKeywords[0] = "W";
        System.out.println(Arrays.toString(commonKeywords));
    }
}
