package com.zyz.algorithm.practice.queue;

/**
 * <p> 单链表 </p>
 *
 * @author: 张易筑
 * @since: 2024/8/19 - 17:46
 */
public class ListNode {

	int val;

	ListNode next;

	void traverse(ListNode head) {
		for (ListNode p = head; p != null; p = p.next) {

		}
	}

	void recursion(ListNode head) {
		recursion(head.next);
	}
}
