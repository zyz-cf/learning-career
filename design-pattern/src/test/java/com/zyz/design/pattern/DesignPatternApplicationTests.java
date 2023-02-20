package com.zyz.design.pattern;

import com.zyz.design.pattern.creational.singleton.LazySimpleSingleton;
import org.junit.jupiter.api.Test;

public class DesignPatternApplicationTests {

    @Test
    public void lazySingletonThreadSafetyTest() {
        Runnable lazySimpleSingletonTask = () -> {
            LazySimpleSingleton simpleSingleton = LazySimpleSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t => \t" + simpleSingleton.hashCode());
        };
        for (int i = 0; i <= 1000; i++) {
            new Thread(lazySimpleSingletonTask, "线程" + i).start();
        }
    }

}
