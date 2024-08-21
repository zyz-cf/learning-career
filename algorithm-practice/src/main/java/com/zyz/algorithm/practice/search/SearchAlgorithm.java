package com.zyz.algorithm.practice.search;

/**
 * <p> 查找算法 </p>
 *
 * @author: 张易筑
 * @since: 2024/8/19 - 8:27
 */
public class SearchAlgorithm {

	/**
	 * 二分查找优化版
	 *
	 * @param num 数组
	 * @param target 查找值
	 * @return {@link int} 返回位置
	 * @author 张易筑
	 * @date 2024-08-19 08:28:46
	 */
	public static int binarySearchBasic(int[] num, int target) {
		int left = 0, right = num.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target < num[mid]) {
				right = mid - 1;
			} else if (num[mid] < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * 二分查找优化版
	 *
	 * @param num 数组
	 * @param target 查找值
	 * @return {@link int} 返回位置
	 * @author 张易筑
	 * @date 2024-08-19 08:28:46
	 */
	public static int binarySearchOptimize(int[] num, int target) {
		int left = 0, right = num.length - 1;
		while (left <= right) {
			int mid = left + right >>> 1;
			if (target < num[mid]) {
				right = mid - 1;
			} else if (num[mid] < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
