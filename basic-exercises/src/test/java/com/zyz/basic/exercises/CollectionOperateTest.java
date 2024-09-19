package com.zyz.basic.exercises;

import com.alibaba.fastjson.JSON;
import com.zyz.basic.exercises.vo.RiskFinanceExcelVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> 集合类测试 </p>
 *
 * @author: 张易筑
 * @since: 2024/8/26 - 15:07
 */
@SpringBootTest
public class CollectionOperateTest {

	@Test
    public void testMapToJson() {
        List<RiskFinanceExcelVO> riskFinanceExcels = new ArrayList<>();

        RiskFinanceExcelVO vo1 = new RiskFinanceExcelVO();
        vo1.setMajorIndex("a");
        vo1.setLastYearYOY("b");
        vo1.setCurrentPeriod("c");
        vo1.setChangeRatio("d");
        vo1.setChangeReason("e");
        riskFinanceExcels.add(vo1);

        RiskFinanceExcelVO vo2 = new RiskFinanceExcelVO();
        vo2.setMajorIndex("aa");
        vo2.setLastYearYOY("bb");
        vo2.setCurrentPeriod("cc");
        vo2.setChangeRatio("dd");
        vo2.setChangeReason("ee");
        riskFinanceExcels.add(vo2);

        Map<String, RiskFinanceExcelVO> map = new HashMap<>();
        riskFinanceExcels.forEach(item -> {
            map.put(item.getMajorIndex(), item);
        });
        System.out.println(map);
        String jsonMapString = JSON.toJSONString(map);
        System.out.println(jsonMapString);

        String jsonListString = JSON.toJSONString(riskFinanceExcels);
        System.out.println(jsonListString);
    }

    @Test
    public void testHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("K1", "V1");
        String mapV = map.put("K1", "V2");
        System.out.println(mapV);
        System.out.println(map.get("K1"));

        Map<String, String> map2 = new HashMap<>();
        map2.put("K1", "V1");
        String map2V = map2.putIfAbsent("K1", "V2");
        System.out.println(map2V);
        System.out.println(map2.get("K1"));
    }
}
