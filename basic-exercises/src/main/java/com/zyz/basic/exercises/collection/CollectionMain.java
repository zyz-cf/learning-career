package com.zyz.basic.exercises.collection;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionMain {

    public static void main(String[] args) {
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
        String jsonString1 = JSON.toJSONString(map);


        String jsonString = JSON.toJSONString(riskFinanceExcels);
        System.out.println(jsonString);

    }
}
