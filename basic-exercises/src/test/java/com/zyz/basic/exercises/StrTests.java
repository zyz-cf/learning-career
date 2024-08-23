package com.zyz.basic.exercises;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.zyz.basic.exercises.vo.CompanyRatingSortVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 糊涂工具类测试
 *
 * @author 张易筑
 * @date 2022/4/19-9:44 星期二
 */
@SpringBootTest
public class StrTests {

    @Test
    @DisplayName("测试基本数据类型通过")
    public void testBasicDataType() {
        System.out.println("byte : " + Byte.class + " Size : " + Byte.SIZE + " MaxSize : " + Byte.MAX_VALUE + " MinSize : " + Byte.MIN_VALUE);
        System.out.println("char : " + Character.class + " Size : " + Character.SIZE + " MaxSize : " + Character.MAX_VALUE + " MinSize : " + Character.MIN_VALUE);
        System.out.println("short : " + Short.class + " Size : " + Short.SIZE + " MaxSize : " + Short.MAX_VALUE + " MinSize : " + Short.MIN_VALUE);
        System.out.println("int : " + Integer.class + " Size : " + Integer.SIZE + " MaxSize : " + Integer.MAX_VALUE + " MinSize : " + Integer.MIN_VALUE);
        System.out.println("long : " + Long.class + " Size : " + Long.SIZE + " MaxSize : " + Long.MAX_VALUE + " MinSize : " + Long.MIN_VALUE);
        System.out.println("float : " + Float.class + " Size : " + Float.SIZE + " MaxSize : " + Float.MAX_VALUE + " MinSize : " + Float.MIN_VALUE);
        System.out.println("double : " + Double.class + " Size : " + Double.SIZE + " MaxSize : " + Double.MAX_VALUE + " MinSize : " + Double.MIN_VALUE);
    }

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

    @Test
    public void testJson() {
                String a = "[\n" +
                "  {\n" +
                "    \"ratingType\":\"外评\",\n" +
                "    \"creditRating\":\"AAA\",\n" +
                "    \"ratingDt\":\"2023-07-19\",\n" +
                "    \"whiteRank\":null,\n" +
                "    \"provinceRank\":null,\n" +
                "    \"countryRank\":null,\n" +
                "    \"provinceTotal\":null,\n" +
                "    \"countryTotal\":null,\n" +
                "    \"countryCompanyIds\":null,\n" +
                "    \"whitTotal\":null\n" +
                "  },\n" +
                "  {\n" +
                "    \"ratingType\":\"YY隐含\",\n" +
                "    \"creditRating\":\"3.82\",\n" +
                "    \"ratingDt\":\"2023-08-01\",\n" +
                "    \"whiteRank\":null,\n" +
                "    \"provinceRank\":null,\n" +
                "    \"countryRank\":null,\n" +
                "    \"provinceTotal\":null,\n" +
                "    \"countryTotal\":null,\n" +
                "    \"countryCompanyIds\":null,\n" +
                "    \"whitTotal\":null\n" +
                "  },\n" +
                "  {\n" +
                "    \"ratingType\":\"CSCS评分\",\n" +
                "    \"creditRating\":\"A\",\n" +
                "    \"ratingDt\":\"2023-08-01\",\n" +
                "    \"whiteRank\":null,\n" +
                "    \"provinceRank\":null,\n" +
                "    \"countryRank\":null,\n" +
                "    \"provinceTotal\":null,\n" +
                "    \"countryTotal\":null,\n" +
                "    \"countryCompanyIds\":null,\n" +
                "    \"whitTotal\":null\n" +
                "  },\n" +
                "  {\n" +
                "    \"ratingType\":\"YY等级\",\n" +
                "    \"creditRating\":\"3\",\n" +
                "    \"ratingDt\":\"2019-10-22\",\n" +
                "    \"whiteRank\":null,\n" +
                "    \"provinceRank\":null,\n" +
                "    \"countryRank\":null,\n" +
                "    \"provinceTotal\":null,\n" +
                "    \"countryTotal\":null,\n" +
                "    \"countryCompanyIds\":null,\n" +
                "    \"whitTotal\":null\n" +
                "  },\n" +
                "  {\n" +
                "    \"ratingType\":\"外评\",\n" +
                "    \"creditRating\":\"AAA\",\n" +
                "    \"ratingDt\":\"2023-08-18\",\n" +
                "    \"whiteRank\":null,\n" +
                "    \"provinceRank\":null,\n" +
                "    \"countryRank\":null,\n" +
                "    \"provinceTotal\":null,\n" +
                "    \"countryTotal\":null,\n" +
                "    \"countryCompanyIds\":null,\n" +
                "    \"whitTotal\":null\n" +
                "  },\n" +
                "  {\n" +
                "    \"ratingType\":\"YY隐含\",\n" +
                "    \"creditRating\":\"2.56\",\n" +
                "    \"ratingDt\":\"2023-09-23\",\n" +
                "    \"whiteRank\":null,\n" +
                "    \"provinceRank\":null,\n" +
                "    \"countryRank\":null,\n" +
                "    \"provinceTotal\":null,\n" +
                "    \"countryTotal\":null,\n" +
                "    \"countryCompanyIds\":null,\n" +
                "    \"whitTotal\":null\n" +
                "  },\n" +
                "  {\n" +
                "    \"ratingType\":\"CSCS评分\",\n" +
                "    \"creditRating\":\"A\",\n" +
                "    \"ratingDt\":\"2023-09-23\",\n" +
                "    \"whiteRank\":null,\n" +
                "    \"provinceRank\":null,\n" +
                "    \"countryRank\":null,\n" +
                "    \"provinceTotal\":null,\n" +
                "    \"countryTotal\":null,\n" +
                "    \"countryCompanyIds\":null,\n" +
                "    \"whitTotal\":null\n" +
                "  },\n" +
                "  {\n" +
                "    \"ratingType\":\"YY等级\",\n" +
                "    \"creditRating\":\"3\",\n" +
                "    \"ratingDt\":\"2019-10-22\",\n" +
                "    \"whiteRank\":null,\n" +
                "    \"provinceRank\":null,\n" +
                "    \"countryRank\":null,\n" +
                "    \"provinceTotal\":null,\n" +
                "    \"countryTotal\":null,\n" +
                "    \"countryCompanyIds\":null,\n" +
                "    \"whitTotal\":null\n" +
                "  },\n" +
                "  {\n" +
                "    \"ratingType\":\"外评\",\n" +
                "    \"creditRating\":\"AAA\",\n" +
                "    \"ratingDt\":\"2023-08-18\",\n" +
                "    \"whiteRank\":null,\n" +
                "    \"provinceRank\":null,\n" +
                "    \"countryRank\":null,\n" +
                "    \"provinceTotal\":null,\n" +
                "    \"countryTotal\":null,\n" +
                "    \"countryCompanyIds\":null,\n" +
                "    \"whitTotal\":null\n" +
                "  },\n" +
                "  {\n" +
                "    \"ratingType\":\"YY等级\",\n" +
                "    \"creditRating\":\"3\",\n" +
                "    \"ratingDt\":\"2019-10-22\",\n" +
                "    \"whiteRank\":null,\n" +
                "    \"provinceRank\":null,\n" +
                "    \"countryRank\":null,\n" +
                "    \"provinceTotal\":null,\n" +
                "    \"countryTotal\":null,\n" +
                "    \"countryCompanyIds\":null,\n" +
                "    \"whitTotal\":null\n" +
                "  },\n" +
                "  {\n" +
                "    \"ratingType\":\"YY隐含\",\n" +
                "    \"creditRating\":\"3.06\",\n" +
                "    \"ratingDt\":\"2024-05-30\",\n" +
                "    \"whiteRank\":null,\n" +
                "    \"provinceRank\":null,\n" +
                "    \"countryRank\":null,\n" +
                "    \"provinceTotal\":null,\n" +
                "    \"countryTotal\":null,\n" +
                "    \"countryCompanyIds\":null,\n" +
                "    \"whitTotal\":null\n" +
                "  },\n" +
                "  {\n" +
                "    \"ratingType\":\"CSCS评分\",\n" +
                "    \"creditRating\":\"A\",\n" +
                "    \"ratingDt\":\"2024-05-30\",\n" +
                "    \"whiteRank\":null,\n" +
                "    \"provinceRank\":null,\n" +
                "    \"countryRank\":null,\n" +
                "    \"provinceTotal\":null,\n" +
                "    \"countryTotal\":null,\n" +
                "    \"countryCompanyIds\":null,\n" +
                "    \"whitTotal\":null\n" +
                "  }\n" +
                "]";
        List<CompanyRatingSortVO> list = JSONUtil.toList(JSONUtil.toJsonStr(a), CompanyRatingSortVO.class);
        System.out.println("fuck:" + list);

        ArrayList<CompanyRatingSortVO> list1 = new ArrayList<>(list.stream()
                .collect(Collectors.toMap(item -> item.getRatingType() + "-" + item.getCreditRating() + "-" + item.getRatingDt()
                        , item -> item
                        , (existing, replacement) -> existing
                )).values());
        System.out.println("cao:" + list1);

    }
}
