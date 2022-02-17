package com.zyz.basic.exercises.juc;

import com.zyz.basic.exercises.juc.lock.CustomizedNotice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 定制化通知测试类
 *
 * @author 张易筑
 * @date 2022/2/15-16:25 星期二
 */
@SpringBootTest
public class CustomizedNoticeTest {
    
    @Test
    public void testCustomizedNotice() {
        CustomizedNotice customizedNotice = new CustomizedNotice();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    customizedNotice.print5(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    customizedNotice.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    customizedNotice.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }
    
}
