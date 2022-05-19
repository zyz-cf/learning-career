package com.zyz.basic.exercises.string;

import cn.hutool.core.util.ObjectUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 糊涂工具类测试
 *
 * @author 张易筑
 * @date 2022/4/19-9:44 星期二
 */
@SpringBootTest
public class HutoolStrTests {

    @Test
    public void strTest() {
        List<String> CROWN_CITY_LIST = new ArrayList<String>() {
            {
                this.add("北京市");
                this.add("上海市");
                this.add("重庆市");
                this.add("天津市");
            }
        };

        System.out.println(ObjectUtil.contains(CROWN_CITY_LIST, "北京市"));
    }
}
