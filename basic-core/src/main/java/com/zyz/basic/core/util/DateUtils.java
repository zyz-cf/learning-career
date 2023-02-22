package com.zyz.basic.core.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * 日期工具类
 *
 * @author 张易筑
 * @date 2023/2/20-14:05 Monday
 */
public class DateUtils {

    /**
     * 获取两个日期间的周日期列表
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return {@link List<LocalDate>} 两个日期间的周日期列表
     * @author 张易筑
     * @date 2023-02-20 14:08:08
     */
    public static List<LocalDate> getBetweenDateWeekDates(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> weekDates = new ArrayList<>();
        // 几周， 每周是哪几天
        LocalDateTime tmp = LocalDateTime.of(LocalDate.from(startDate.minusDays(startDate.getDayOfWeek().getValue() - 1)), LocalTime.MIN);
        ChronoUnit unit = ChronoUnit.WEEKS;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 用于转换 周结束日期
        TemporalAdjuster LAST_OF_WEEK = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.plusDays(DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue()));
        Map<Long, List<String>> weekMap = new HashMap<>();
        while (tmp.isBefore(endDate.atStartOfDay()) || tmp.isEqual(endDate.atStartOfDay())) {
            // 求 tmp 是哪一周
            LocalDateTime endWeek = tmp.with(LAST_OF_WEEK);     //开始周结束日期
            List<String> list = new ArrayList<>();
            weekMap.put(tmp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), list);
            while (tmp.isBefore(endWeek) || tmp.isEqual(endWeek)) {
                list.add(tmp.format(formatter));
                tmp = tmp.plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
            }
        }
        Map<Long, List<String>> result = new LinkedHashMap<>();
        //排序
        weekMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        for (Long key : result.keySet()) {
            LocalDateTime keys = LocalDateTime.ofInstant(Instant.ofEpochMilli(key), ZoneId.systemDefault());
            // System.out.println("key=" + keys + ",vlaue=" + result.get(key).toString());
            weekDates.add(keys.toLocalDate());
        }
        return weekDates;
    }

    /**
     * 获取季度
     *
     * @param cal 日期
     * @return {@link int} 季度
     * @author 张易筑
     * @date 2023-02-20 14:33:09
     */
    public static int getQuarter(LocalDate cal) {
        int month = cal.get(ChronoField.MONTH_OF_YEAR);
        switch (Month.of(month)) {
            case JANUARY:
            case FEBRUARY:
            case MARCH:
            default:
                return 1;
            case APRIL:
            case MAY:
            case JUNE:
                return 2;
            case JULY:
            case AUGUST:
            case SEPTEMBER:
                return 3;
            case OCTOBER:
            case NOVEMBER:
            case DECEMBER:
                return 4;
        }
    }

    /**
     * Calculates the number of quarters between two given dates
     *
     * @param startDate First given date cannot be null
     * @param endDate   Second given date cannot be null
     * @return {@link int} Number of quarters
     * @author 张易筑
     * @date 2023-02-20 14:51:01
     */
    public static int getQuartersBetweenDates(LocalDate startDate, LocalDate endDate) {
        LocalDate begin = null;
        LocalDate end = null;
        if (startDate.isBefore(endDate)) {
            begin = startDate;
            end = endDate;
        } else {
            begin = endDate;
            end = startDate;
        }
        int quarters = getQuarter(end) - getQuarter(begin);
        int years = end.get(ChronoField.YEAR) - begin.get(ChronoField.YEAR);
        quarters += years * 4;
        return Math.abs(quarters);
    }

    /**
     * 返回四季
     *
     * @param date 日期
     * @param num 返回多少数
     * @return {@link List<String>}
     * @author 张易筑
     * @date 2023-02-20 14:54:01
     */
    public static List<String> getLatest4Quarter(LocalDate date, int num) {
        List<String> quaterList = new ArrayList<>();
        for (int i = 0; i <= num - 1; i++) {
            LocalDate localDate = date.minusMonths(3L * i);
            String year = localDate.toString().substring(0, 4);
            String monthStr = localDate.toString().substring(5, 7);
            int quarterNum = ((Integer.parseInt(monthStr) + 2) / 3);
            String quarter = year + "Q" + quarterNum;
            quaterList.add(quarter);
        }
        return quaterList;
    }

    public static void main(String[] args) {
        System.out.println(getBetweenDateWeekDates(LocalDate.parse("2022-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.now()));
        System.out.println(getQuarter(LocalDate.now()));
    }
}
