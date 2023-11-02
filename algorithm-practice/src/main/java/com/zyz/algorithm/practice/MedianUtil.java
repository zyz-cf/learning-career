package com.zyz.algorithm.practice;

import java.util.PriorityQueue;

/**
 * 中位数
 *
 * @author 张易筑
 * @date 2023/3/21-13:41 Tuesday
 */
public class MedianUtil {

    /**
     * 大顶堆，存储左半边元素 （需重写比较器）
     **/
    private final PriorityQueue<Double> left = new PriorityQueue<>((o1, o2) -> (int) (o2 - o1));
    /**
     * 小顶堆，存储右半边元素，并且右半边元素都大于左半边
     **/
    private final PriorityQueue<Double> right = new PriorityQueue<>();

    /**
     * 当前数据流读入的元素个数，用于判断奇偶
     **/
    private int count = 0;

    /**
     * 读取数据流
     *
     * @param num 数字
     */
    public void insert(double num) {
        count++;
        // 为了实现平衡分配，可以在数据的总数目是偶数时把数据插入最小堆，否则插入最大堆
        if ((count & 1) == 0) {
            // 在要把数据插入最小堆的时候，如果该数比最大堆的一些数还要小
            // 那么需要先插入最大堆，把最大堆的最大值拿出来出入到最小堆
            // 反之亦然
            if (right.size() != 0 && num < right.peek()) {
                left.add(num);
                right.add(left.poll());
            } else {
                right.add(num);
            }
        } else {
            if (left.size() != 0 && num > left.peek()) {
                right.add(num);
                left.add(right.poll());
            } else {
                left.add(num);
            }
        }
    }

    /**
     * 获取当前读取数据的中位数
     */
    public Double getMedian() {
        if ((count & 1) == 1) {
            return left.peek() == null ? 0.0 : left.peek();
        } else {
            Double leftPeek = left.peek() == null ? 0.0 : left.peek();
            Double rightPeek = right.peek() == null ? 0.0 : right.peek();
            return (leftPeek + rightPeek) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianUtil median = new MedianUtil();
        median.insert(1);
        median.insert(2);
        median.insert(3);
        median.insert(4);
        median.insert(5);
        median.insert(7);
        median.insert(1);
        median.insert(5);
        median.insert(6);

        System.out.println(median.getMedian());
    }
}

