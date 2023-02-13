package com.zyz.basic.exercises.date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Date练习
 *
 * @author 张易筑
 * @date 2021-06-24 08:52
 */
@SpringBootTest
public class RehearseDateTest {

    @Test
    public void testDateConvert() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());

        LocalDate localDate1 = localDate.minusMonths(6);
        System.out.println(localDate.toString());


        /*java8 (yyyyMMddHHmmss) 转 (yyyy-MM-dd HH:mm:ss)*/
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime ldt = LocalDateTime.parse("20211208091721", dtf);

        DateTimeFormatter fa = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String logTime = ldt.format(fa);
        LocalDateTime localDateTime = LocalDateTime.parse(logTime, fa);
        System.out.println(localDateTime);

        int year = localDate.getYear();
        int monthValue = localDate.getMonthValue();
        System.out.println("year:" + year + "month:" + monthValue);

        LocalDate today = LocalDate.parse("2012-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate sunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));


    }
}
