package com.zyz.basic.exercises.date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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

        System.out.println(Instant.ofEpochMilli(1685064228000L).atZone(ZoneOffset.ofHours(8)).toLocalDate());

        System.out.println(LocalDateTime.ofEpochSecond(1685064228000L / 1000, 0, ZoneOffset.ofHours(8)));

        System.out.println(LocalDateTime.parse("20230508000000", DateTimeFormatter.ofPattern("yyyyMMddHHmmss")).toLocalDate());


        LocalDate ofDate = LocalDate.of(2022, 1, 1);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
        System.out.println(localDate);
        System.out.println(ofDate.isAfter(localDate));
        System.out.println(ofDate.isBefore(localDate));

        LocalDate localDate1 = localDate.minusMonths(6);
        System.out.println(localDate);

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

        // 获取今年第一天及最后一天
        LocalDateTime firstDayOfYear = LocalDateTime.of(LocalDate.from(ofDate.with(TemporalAdjusters.firstDayOfYear())), LocalTime.MIN);
        LocalDateTime lastDayOfYear = LocalDateTime.of(LocalDate.from(ofDate.with(TemporalAdjusters.lastDayOfYear())), LocalTime.MAX);

        LocalDateTime sixSectionDate = LocalDateTime.of(LocalDate.of(ofDate.getYear(), Month.JUNE, Month.JUNE.maxLength()), LocalTime.MAX);
        LocalDateTime sevenSectionDate = LocalDateTime.of(LocalDate.of(ofDate.getYear(), Month.JULY, 1), LocalTime.MIN);

        System.out.println(firstDayOfYear);
        System.out.println(lastDayOfYear);
        System.out.println(sixSectionDate);
        System.out.println(sevenSectionDate);

    }

    @Test
    public void test() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, String> condition = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 6);
        condition.put("time", df.format(calendar.getTime()));
        condition.put("timestamp", String.valueOf(calendar.getTime().getTime()));
        System.out.println(condition);
    }

    @Test
    public static void dayOfQuarter(String[] args) {
        LocalDate nowDate = LocalDate.now();

        System.out.println("本年第一天:" + nowDate.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("本年最后一天:" + nowDate.with(TemporalAdjusters.lastDayOfYear()));

        // 本季度第一天
        int month = nowDate.getMonthValue();
        LocalDate firstDayOfQuarter;
        if (month <= 3) {
            firstDayOfQuarter = LocalDate.of(nowDate.getYear(), Month.JANUARY, 1);
        } else if (month <= 6) {
            firstDayOfQuarter = LocalDate.of(nowDate.getYear(), Month.APRIL, 1);
        } else if (month <= 9) {
            firstDayOfQuarter = LocalDate.of(nowDate.getYear(), Month.JULY, 1);
        } else {
            firstDayOfQuarter = LocalDate.of(nowDate.getYear(), Month.OCTOBER, 1);
        }
        System.out.println("本季度第一天:" + firstDayOfQuarter);
        System.out.println("本季度最后一天:" + nowDate.plusMonths(3 - nowDate.getMonthValue() % 3).with(TemporalAdjusters.lastDayOfMonth()));

        System.out.println("本月第一天:" + nowDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("本月最后一天:" + nowDate.with(TemporalAdjusters.lastDayOfMonth()));

        // DayOfWeek可指定一周从星期几开始
        System.out.println("本周第一天:" + nowDate.with(DayOfWeek.MONDAY));
        System.out.println("本周最后一天:" + nowDate.with(DayOfWeek.SUNDAY));
    }

}
