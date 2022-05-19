package com.zyz.basic.exercises.decimal;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DecimalOperateTest {

    @Test
    public void testDecimalOperate() {

        BigDecimal earningRate = new BigDecimal("10");
        BigDecimal capitalCost = new BigDecimal("5");
        BigDecimal creditQuota = new BigDecimal("500");
        BigDecimal projectTerm = new BigDecimal("100");

        BigDecimal expectedProfit = earningRate
                .subtract(capitalCost)
                .multiply(creditQuota)
                .divide(BigDecimal.valueOf(360), 4, BigDecimal.ROUND_HALF_UP)
                .multiply(projectTerm);
        System.out.println(expectedProfit);

        List<BigDecimal> bigDecimalList = new ArrayList<>();
        bigDecimalList.add(BigDecimal.valueOf(1));
        bigDecimalList.add(BigDecimal.valueOf(2));
        bigDecimalList.add(BigDecimal.valueOf(3));
        bigDecimalList.add(BigDecimal.valueOf(4));
        BigDecimal reduce = bigDecimalList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce);

        System.out.println(StrUtil.concat(true, Convert.toStr(BigDecimal.valueOf(1)), "%"));
    }
}

