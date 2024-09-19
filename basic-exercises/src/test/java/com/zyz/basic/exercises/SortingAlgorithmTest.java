package com.zyz.basic.exercises;

import com.zyz.algorithm.practice.sort.SortingAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p> 排序算法测试 </p>
 *
 * @author: 张易筑
 * @since: 2024/8/26 - 19:07
 */
@SpringBootTest
public class SortingAlgorithmTest {

	@Test
	public void testBubbleSorting() {
		int[] arr = {3, 21, 15, 17, 46, 37, 29, 58, 6, 11, 25};
		SortingAlgorithm.bubbleSortingBasic(arr);
		SortingAlgorithm.bubbleSortingOptimize(arr);
		SortingAlgorithm.insertionSorting(arr);
	}
}
