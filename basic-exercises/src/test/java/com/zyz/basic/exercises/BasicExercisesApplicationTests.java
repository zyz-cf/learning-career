package com.zyz.basic.exercises;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import com.baomidou.mybatisplus.core.toolkit.AES;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BasicExercisesApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) throws JsonProcessingException {
        // String randomKey = AES.generateRandomKey();
        String randomKey = "32768f84e8b83597";
        System.out.println(randomKey);
        String data = "NDp0T1gi3U";
        String encrypt = AES.encrypt(data, randomKey);
        String decrypt = AES.decrypt("hr2EMfkzxqkB9mwof4wlFacOKdoqjMYf9e4H3Ssxw9w=", randomKey);
        System.out.println(StrUtil.format("加密串[{}], 解密串[{}]", encrypt, decrypt));

        System.out.println(ObjectUtil.contains("200 OK", HttpStatus.HTTP_OK));
        /*String str = "{" +
                "\"name\": null," +
                "\"age\": 11" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = objectMapper.readValue(str, Map.class);
        System.out.println(map.getOrDefault("name", "Hello World!"));

        List<Long> a = Arrays.asList(1L,2L,3L);
        System.out.println(StrUtil.join(",", a));

        LocalDate today = LocalDate.parse("2012-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate sunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println(monday);

        LocalDate now = LocalDate.now();

        LocalDate startDate = LocalDate.parse("2021-07-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse("2021-12-31", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localDate = LocalDate.parse("2022-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println(localDate.isAfter(startDate));
        System.out.println(localDate.isEqual(startDate));
        System.out.println(localDate.isBefore(endDate));

        System.out.println((localDate.isAfter(startDate) || localDate.isEqual(startDate)) && localDate.isBefore(endDate));

        LocalDateTime sixSectionDate = LocalDateTime.of(LocalDate.of(now.getYear(), Month.JUNE, Month.JUNE.maxLength()), LocalTime.MAX);
        LocalDateTime sevenSectionDate = LocalDateTime.of(LocalDate.of(now.getYear(), Month.JULY, 1), LocalTime.MIN);
        System.out.println(sixSectionDate);
        System.out.println(sevenSectionDate);*/
    }
}
