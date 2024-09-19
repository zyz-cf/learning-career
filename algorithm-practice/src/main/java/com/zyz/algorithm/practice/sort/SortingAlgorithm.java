package com.zyz.algorithm.practice.sort;

import java.util.Arrays;

/**
 * <p> 搜索算法 </p>
 *
 * @author: 张易筑
 * @since: 2024/8/26 - 18:45
 */
public class SortingAlgorithm {

	/**
	 * 冒泡排序基础版本
	 *
	 * @param arr 待排序的数组
	 * @author 张易筑
	 * @date 2024-08-26 18:46:58
	 */
	public static void bubbleSortingBasic(int[] arr) {
		int n = arr.length - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if (arr[j] >= arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		String printStr = "冒泡排序基础版：";
		printArr(arr, printStr);
	}

	/**
	 * 冒泡排序优化版本
	 *
	 * @param arr 待排序的数组
	 * @author 张易筑
	 * @date 2024-08-27 08:39:23
	 */
	public static void bubbleSortingOptimize(int[] arr) {
		int n = arr.length - 1;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n -i; j++) {
				if (arr[j] >= arr[j + 1]) {
					flag = true;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				if (!flag) {
					break;
				} else {
					flag = false;
				}
			}
		}
		String printStr = "冒泡排序优化版：";
		printArr(arr, printStr);
	}

	/**
	 * 插入排序
	 *
	 * @param arr 待排序的数组
	 * @author 张易筑
	 * @date 2024-08-27 13:32:11
	 */
	public static void insertionSorting(int[] arr) {
		int n = arr.length - 1;
		for (int i = 0; i < n; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] >= temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
		String printStr = "插入排序：";
		printArr(arr, printStr);
	}

	/**
	 * 答应数组
	 *
	 * @param arr 数组
	 * @author 张易筑
	 * @date 2024-08-27 13:37:17
	 */
	private static void printArr(int[] arr, String printStr) {
		System.out.print(printStr);
		Arrays.stream(arr).forEach(item -> {
			System.out.print(item + " ");
		});
		System.out.println();
	}
}
