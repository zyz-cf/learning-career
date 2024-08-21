package com.zyz.basic.exercises;

import com.zyz.algorithm.practice.search.SearchAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlgorithmPracticeApplicationTests {

    @Test
    @DisplayName("验证正常能找到的二分查找情况通过")
    public void testBinarySearchBasic() {
        int[] nums = {11, 14, 23, 27, 35, 48, 51};
        Assertions.assertEquals(0, SearchAlgorithm.binarySearchBasic(nums, 11));
        Assertions.assertEquals(1, SearchAlgorithm.binarySearchBasic(nums, 14));
        Assertions.assertEquals(2, SearchAlgorithm.binarySearchBasic(nums, 23));
        Assertions.assertEquals(3, SearchAlgorithm.binarySearchBasic(nums, 27));
        Assertions.assertEquals(4, SearchAlgorithm.binarySearchBasic(nums, 35));
        Assertions.assertEquals(5, SearchAlgorithm.binarySearchBasic(nums, 48));
        Assertions.assertEquals(6, SearchAlgorithm.binarySearchBasic(nums, 51));
        Assertions.assertEquals(-1, SearchAlgorithm.binarySearchBasic(nums, 100));
    }


    @Test
    @DisplayName("验证正常能找到的二分查找优化情况通过")
    public void testBinarySearchOptimize() {
        int[] nums = {11, 14, 23, 27, 35, 48, 51};
        Assertions.assertEquals(0, SearchAlgorithm.binarySearchOptimize(nums, 11));
        Assertions.assertEquals(1, SearchAlgorithm.binarySearchOptimize(nums, 14));
        Assertions.assertEquals(2, SearchAlgorithm.binarySearchOptimize(nums, 23));
        Assertions.assertEquals(3, SearchAlgorithm.binarySearchOptimize(nums, 27));
        Assertions.assertEquals(4, SearchAlgorithm.binarySearchOptimize(nums, 35));
        Assertions.assertEquals(5, SearchAlgorithm.binarySearchOptimize(nums, 48));
        Assertions.assertEquals(6, SearchAlgorithm.binarySearchOptimize(nums, 51));
        Assertions.assertEquals(-1, SearchAlgorithm.binarySearchBasic(nums, 100));
    }



}
