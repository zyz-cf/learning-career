package com.zyz.basic.exercises.lambda;

import cn.hutool.core.util.StrUtil;
import com.zyz.basic.exercises.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * stream操作
 *
 * @author 张易筑
 * @date 2021-06-25 16:55
 */
@SpringBootTest
public class StreamOperateTest {

    @Test
    public static void testStreamOperate() {
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
        list.stream().filter(stu -> {
            if (Integer.parseInt(stu.get("age").toString()) > 20) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList()).forEach(System.out::println);
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
        List<Map<String, Object>> list = new ArrayList<>();
        list = Arrays.asList(map1, map2, map3);
        return list;
    }

    @Test
    public void testOrder() {
        OrderService orderService = () -> System.out.println("Come on order");
        orderService.addOrder();
        orderService.getOrder();
        orderService.printOrder();
    }

    @Test
    public void testMember() {
        MemberService memberService = (memberId, memberName) -> {
            System.out.println(StrUtil.format("add member:{}-{}", memberId, memberName));
            return new Member(memberId, memberName);
        };
        memberService.addMember(1L, "zyz");
        memberService.getMember();
    }
}
