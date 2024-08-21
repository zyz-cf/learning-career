package com.zyz.basic.exercises;

import cn.hutool.core.util.StrUtil;
import com.zyz.basic.exercises.lambda.Member;
import com.zyz.basic.exercises.lambda.MemberService;
import com.zyz.basic.exercises.lambda.OrderService;
import com.zyz.basic.exercises.lambda.PayService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * stream操作
 *
 * @author 张易筑
 * @date 2021-06-25 16:55
 */
@SpringBootTest
public class LambdaOperateTest {

    @Test
    public void testLambdaThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am a salted fish.");
            }
        }).start();

        new Thread(() -> System.out.println("The same to you.")).start();
    }

    @Test
    public void testOrder() {
        OrderService orderService = () -> System.out.println("Come on order");
        orderService.addOrder();
        orderService.getOrder();
        orderService.printOrder();

        OrderService orderService1 = new OrderService() {
            @Override
            public void addOrder() {
                System.out.println("Come on order1");
            }
        };
        orderService1.addOrder();
        orderService1.getOrder();
        orderService1.printOrder();
    }

    @Test
    public void testMember() {
        MemberService memberService = (memberId, memberName) -> {
            System.out.println(StrUtil.format("add member:{}-{}", memberId, memberName));
            return new Member(memberId, memberName);
        };
        memberService.addMember(1L, "zyz");
        memberService.getMember();

        MemberService memberService1 = Member::new;
        memberService1.addMember(2L, "cf");
        memberService1.getMember();
    }

    @Test
    public void testPay() {
        PayService payService = new LambdaOperateTest() :: toPay;
        payService.toPay(1000L);

        PayService payService1 = (money) -> {
            System.out.println(money + "我在调用支付接口");
        };
        payService1.toPay(1000L);

        PayService payService2 = money -> System.out.println(money + "我在调用支付接口");
        payService2.toPay(1000L);
    }

    public void toPay(Long money) {
        System.out.println("I am dollars: " + money);
    }
}
