package com.zyz.basic.exercises.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream操作测试
 *
 * @author 张易筑
 * @date 2022/1/19-17:09 星期三
 */
public class StreamOperateTest {

    /**
     * 构造流的几种常见方法
     *
     * @author 张易筑
     * @date 2022-01-20 13:29:28
     */
    @Test
    public void testCreateStream() {
        // 1、使用Stream.of()方法
        Stream<String> stringStream = Stream.of("ZYZ", "CF", "ZYZ-CF");
        stringStream.forEach(System.out::println);

        // 2、使用Arrays.stream()方法
        String[] strArray = new String[]{"ZYZ", "CF", "ZYZ-CF"};
        Stream<String> strStreamArray = Arrays.stream(strArray);
        strStreamArray.forEach(System.out::println);

        // 3、使用list.stream()方法
        List<String> stringList = Arrays.asList(strArray);
        Stream<String> stringListStream = stringList.stream();
        stringListStream.forEach(System.out::println);
    }

    /**
     * stream转换为对象
     *
     * @author 张易筑
     * @date 2022-01-20 13:38:17
     */
    @Test
    public void testStreamConvertObject() {
        Stream<String> stream = Stream.of("ZYZ", "CF", "ZYZ-CF");
        String[] strings = stream.toArray(String[]::new);

        stream = Stream.of("ZYZ", "CF", "ZYZ-CF");
        List<String> collect = stream.collect(Collectors.toList());

        stream = Stream.of("ZYZ", "CF", "ZYZ-CF");
        List<String> collect1 = stream.collect(Collectors.toCollection(ArrayList::new));

        stream = Stream.of("ZYZ", "CF", "ZYZ-CF");
        Set<String> stringSet = stream.collect(Collectors.toSet());

        stream = Stream.of("ZYZ", "CF", "ZYZ-CF");
        String str = stream.collect(Collectors.joining());
    }

    @Test
    public void testStreamOperate() {
        List<Map<String, Object>> list = list();
        // list.stream().filter(stu->stu.get("sex").equals("男")).collect(Collectors.toList()).forEach(System.out::println);

        /*List<Map<String, Object>> list1 = list.stream().filter(stu -> {
            if (Integer.parseInt(stu.get("age").toString()) > 20) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        System.out.println(list1);*/

        list.stream().filter(stu -> Integer.parseInt(stu.get("age").toString()) > 20).collect(Collectors.toList()).forEach(System.out::println);
        list.stream().filter(StreamOperateTest::judgeLogic).collect(Collectors.toList()).forEach(System.out::println);

    }

    private static boolean judgeLogic(Map<String, Object> stu) {
        return Integer.parseInt(stu.get("age").toString()) > 20;
    }

    public static List<Map<String, Object>> list() {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", "1");
        map1.put("name", "小张");
        map1.put("age", "10");
        map1.put("sex", "男");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", "2");
        map2.put("name", "小李");
        map2.put("age", "15");
        map2.put("sex", "女");
        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", "3");
        map3.put("name", "小王");
        map3.put("age", "30");
        map3.put("sex", "男");
        return Arrays.asList(map1, map2, map3);
    }
}
