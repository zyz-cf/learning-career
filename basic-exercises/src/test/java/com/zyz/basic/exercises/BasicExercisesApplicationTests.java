package com.zyz.basic.exercises;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BasicExercisesApplicationTests {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) throws JsonProcessingException {
		List<Plan> lt = new ArrayList<>();
		lt.add(Plan.builder().a(100).b(0.2).c(50).build());
		lt.add(Plan.builder().b(0.3).build());
		lt.add(Plan.builder().b(0.3).build());
		lt.add(Plan.builder().b(0.2).build());
		List<Plan> plans = lt.subList(1, lt.size());
		int index = 0;
		Plan pre = lt.get(0);
		double residueInitialInvestAmount = 50;
		double totalRatio = 1;
		double d1 = (pre.getA() - residueInitialInvestAmount) * pre.getB();
		pre.setD(d1);
		for (Plan next : plans) {
			double nextRatio = next.getB();
			double nextEnd = (residueInitialInvestAmount * nextRatio) / totalRatio;
			next.setD(nextEnd);
			double nextInit;
			if (index == 0) {
				nextInit = pre.getA() - residueInitialInvestAmount - pre.getD();
			} else {
				nextInit = pre.getA() - pre.getD();
			}
			next.setA(nextInit);
			pre = next;
			index++;
		}

		for (Plan plan : lt) {
			System.out.println(plan);
		}
	}
}

@Data
@Builder
@ToString
class Plan {
	double a;
	double b;
	double c;
	double d;
}