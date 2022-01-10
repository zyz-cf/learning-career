package com.zyz.basic.exercises.decimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

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
    }
}

