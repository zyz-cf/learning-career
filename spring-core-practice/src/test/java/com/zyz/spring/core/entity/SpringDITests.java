package com.zyz.spring.core.entity;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入测试
 *
 * @author 张易筑
 * @date 2022/4/22-14:03 星期五
 */
public class SpringDITests {

    @Test
    public void testDI() {
        ApplicationContext context = new ClassPathXmlApplicationContext("user-bean.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
    }

    @Test
    public void testAutowired() {
        ApplicationContext context = new ClassPathXmlApplicationContext("people-bean.xml");
        People people = context.getBean("people", People.class);
        people.getCat().say();
        people.getDog().say();
        System.out.println(people);
    }
}
