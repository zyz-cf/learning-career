package com.zyz.algorithm.practice.array;

import java.util.Arrays;

/**
 * 移动数组
 *
 * @author 张易筑
 * @date 2022/4/6-9:32 星期三
 */
public class MoveZeroes {

    /**
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     */
    public static void moveZeroes (int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
    
}
