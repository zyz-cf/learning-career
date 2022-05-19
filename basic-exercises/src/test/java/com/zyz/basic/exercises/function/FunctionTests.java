package com.zyz.basic.exercises.function;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * 四大函数式接口
 *
 * @author 张易筑
 * @date 2022/5/12-8:39 星期四
 */
public class FunctionTests {

    @Test
    public void testFunction() {

        // 有传入值，有反馈值
        /**
         *  Function<T, R> T: 传入值 R：反馈值
         *  R apply(T t);
         */
        /*Function<String, String> func = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };*/

        Function<String, String> func = s -> s;
        System.out.println(func.apply("Hello World"));
    }
}
