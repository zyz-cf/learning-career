package com.zyz.basic.exercises.reference;

import java.lang.reflect.Field;

/**
 * 字符串操作
 *
 * @author 张易筑
 * @date 2022/4/7-13:09 星期四
 */
public class StringOperate {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s = new String("abc");
        Field value = s.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(s, "abcd".toCharArray());
        System.out.println(s);

        String s1 = new String("abc");
        String s2 = "abc";
        System.out.println(s1 == s2);
        String s3 = s1.intern();
        System.out.println(s2 == s3);
    }
}
