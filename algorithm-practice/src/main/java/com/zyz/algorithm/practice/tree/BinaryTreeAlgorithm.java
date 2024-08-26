package com.zyz.algorithm.practice.tree;

import cn.hutool.core.util.ObjectUtil;

import java.util.*;

/**
 * <p> 二叉树算法 </p>
 *
 * @author: 张易筑
 * @since: 2024/8/22 - 16:54
 */
public class BinaryTreeAlgorithm {

	/**
	 * 二叉树高度
	 *
	 * @param root 二叉树
	 * @return {@link int} 二叉树高度
	 * @author 张易筑
	 * @date 2024-08-22 16:59:00
	 */
	public static int treeHeight(TreeNode root) {
		if (ObjectUtil.isEmpty(root)) {
			return 0;
		}
		int leftHeight = treeHeight(root.left);
		int rightHeight = treeHeight(root.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	/**
	 * 二叉树宽度
	 *
	 * @param root 二叉树
	 * @return {@link int} 二叉树宽度
	 * @author 张易筑
	 * @date 2024-08-23 14:29:39
	 */
	public static int treeWeight(TreeNode root) {
		int maxWeight = 0;
		if (ObjectUtil.isEmpty(root)) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int currentLevelSize = queue.size();
			for (int i = 0; i < currentLevelSize; i++) {
				TreeNode current = queue.poll();
				assert current != null;
				if (current.left != null) {
					queue.offer(current.left);
				}
				if (current.right != null) {
					queue.offer(current.right);
				}
			}
			maxWeight = Math.max(maxWeight, currentLevelSize);
		}
		return maxWeight;
	}

	/**
	 * 二叉树层次遍历（广度优先）
	 *
	 * @param root 二叉树
	 * @author 张易筑
	 * @date 2024-08-23 18:14:38
	 */
	public static void treeLevelTraversal(TreeNode root) {
		if (ObjectUtil.isEmpty(root)) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			System.out.print(current.val + " ");
			if (current.left != null) {
				queue.offer(current.left);
			}
			if (current.right != null) {
				queue.offer(current.right);
			}
		}
	}

	/**
	 * 二叉树层次遍历（广度优先）-改进版
	 *
	 * @param root 二叉树
	 * @author 张易筑
	 * @date 2024-08-22 18:38:03
	 */
	public static List<List<Integer>> treeLevelTraversalImprove(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (ObjectUtil.isEmpty(root)) {
			return Collections.emptyList();
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> levels = new ArrayList<>();
			int currentLevelSize = queue.size();
			for (int i = 0; i < currentLevelSize; i++) {
				TreeNode current = queue.poll();
				assert current != null;
				levels.add(current.val);
				if (current.left != null) {
					queue.offer(current.left);
				}
				if (current.right != null) {
					queue.offer(current.right);
				}
			}
			result.add(levels);
		}
		return result;
	}

	/**
	 * 二叉树蛇刑输出
	 *
	 * @param root 二叉树
	 * @return {@link List<List<Integer>>} 每一层的输出列表
	 * @author 张易筑
	 * @date 2024-08-23 18:29:56
	 */
	public static List<List<Integer>> treeLevelZigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean isOrderLeft = true;
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int currentLevelSize = queue.size();
			for (int i = 0; i < currentLevelSize; i++) {
				TreeNode currentNode = queue.poll();
				if (isOrderLeft) {
					assert currentNode != null;
					level.add(currentNode.val);
				} else {
					assert currentNode != null;
					level.add(0, currentNode.val);
				}
				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			result.add(level);
			isOrderLeft = !isOrderLeft;
		}
		return result;
	}

	/**
	 * 二叉树深度优先遍历
	 *
	 * @param root 二叉树
	 * @author 张易筑
	 * @date 2024-08-23 18:47:38
	 */
	public static void treeDFSTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode current = stack.pop();
			System.out.print(current.val + " ");
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
	}

	/**
	 * 二叉树前序遍历
	 *
	 * @param root 二叉树
	 * @author 张易筑
	 * @date 2024-08-23 14:32:37
	 */
	public static void treePreOrderTraversal(TreeNode root) {
		if (ObjectUtil.isEmpty(root)) {
			return;
		}
		System.out.print(root.val + " ");
		treePreOrderTraversal(root.left);
		treePreOrderTraversal(root.right);
	}

	/**
	 * 二叉树中序遍历
	 *
	 * @param root 二叉树
	 * @author 张易筑
	 * @date 2024-08-23 14:33:00
	 */
	public static void treeMidOrderTraversal(TreeNode root) {
		if (ObjectUtil.isEmpty(root)) {
			return;
		}
		treeMidOrderTraversal(root.left);
		System.out.print(root.val + " ");
		treeMidOrderTraversal(root.right);
	}

	/**
	 * 二叉树后序遍历
	 *
	 * @param root 二叉树
	 * @author 张易筑
	 * @date 2024-08-23 14:33:30
	 */
	public static void treePostOrderTraversal(TreeNode root) {
		if (ObjectUtil.isEmpty(root)) {
			return;
		}
		treePostOrderTraversal(root.left);
		treePostOrderTraversal(root.right);
		System.out.print(root.val + " ");
	}
}
