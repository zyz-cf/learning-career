package com.zyz.algorithm.practice.tree;

import cn.hutool.core.util.ObjectUtil;

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

		return 0;
	}

	/**
	 * 二叉树层次遍历
	 *
	 * @param root 二叉树
	 * @author 张易筑
	 * @date 2024-08-22 18:38:03
	 */
	public static void treeLevelTraversal(TreeNode root) {

	}

	/**
	 * 二叉树前序遍历
	 *
	 * @param root 二叉树
	 * @author 张易筑
	 * @date 2024-08-23 14:32:37
	 */
	public static void treePreOrderTraversal(TreeNode root) {

	}

	/**
	 * 二叉树中序遍历
	 *
	 * @param root 二叉树
	 * @author 张易筑
	 * @date 2024-08-23 14:33:00
	 */
	public static void treeMidOrderTraversal(TreeNode root) {

	}

	/**
	 * 二叉树后序遍历
	 *
	 * @param root 二叉树
	 * @author 张易筑
	 * @date 2024-08-23 14:33:30
	 */
	public static void treePostOrderTraversal(TreeNode root) {

	}


	/*
public class BinaryTreeTraversal {

    // 前序遍历（先根遍历）
    public void preorderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // 中序遍历（中根遍历）
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    // 后序遍历（后根遍历）
    public void postorderTraversal(TreeNode root) {
        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    // 层次遍历
    public void levelOrderTraversal(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    public static void main(String[] args) {
        // 示例树:
        //      1
        //     / \
        //    2   3
        //   / \   \
        //  4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        BinaryTreeTraversal traversal = new BinaryTreeTraversal();
        System.out.println("Preorder traversal: ");
        traversal.preorderTraversal(root);
        System.out.println("\nInorder traversal: ");
        traversal.inorderTraversal(root);
        System.out.println("\nPostorder traversal: ");
        traversal.postorderTraversal(root);
        System.out.println("\nLevel order traversal: ");
        traversal.levelOrderTraversal(root);
    }
}


public class BinaryTreeHeight {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        BinaryTreeHeight solution = new BinaryTreeHeight();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        int height = solution.height(node1);
        System.out.println("Height of the binary tree is: " + height);
    }
}


public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}


public class BinaryTreeWidth {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxWidth = 1;
        int currentLevelWidth = 0;
        int nextLevelWidth = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currentLevelWidth++;

            if (node.left != null) {
                queue.offer(node.left);
                nextLevelWidth++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevelWidth++;
            }

            if (queue.isEmpty()) {
                maxWidth = Math.max(maxWidth, currentLevelWidth);
                currentLevelWidth = 0;
                maxWidth = Math.max(maxWidth, nextLevelWidth);
                currentLevelWidth = nextLevelWidth;
                nextLevelWidth = 0;
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        // 示例二叉树：
        //      1
        //     / \
        //    2   3
        //   / \   \
        //  4   5   6
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        BinaryTreeWidth binaryTreeWidth = new BinaryTreeWidth();
        int width = binaryTreeWidth.widthOfBinaryTree(node1);
        System.out.println("Width of Binary Tree: " + width); // 输出应为 3
    }
}


	//广度优先遍历是使用队列实现的
	public void BroadFirstSearch(TreeNode nodeHead) {
		if(nodeHead==null) {
			return;
		}
		Queue<TreeNode> myQueue=new LinkedList<>();
		myQueue.add(nodeHead);
		while(!myQueue.isEmpty()) {
			TreeNode node=myQueue.poll();
			System.out.print(node.data+" ");
			if(null!=node.leftNode) {
				myQueue.add(node.leftNode);    //深度优先遍历，我们在这里采用每一行从左到右遍历
			}
			if(null!=node.rightNode) {
				myQueue.add(node.rightNode);
			}

		}
	}

	//深度优先遍历
	public void depthFirstSearch(TreeNode nodeHead) {
		if(nodeHead==null) {
			return;
		}
		Stack<TreeNode> myStack=new Stack<>();
		myStack.add(nodeHead);
		while(!myStack.isEmpty()) {
			TreeNode node=myStack.pop();    //弹出栈顶元素
			System.out.print(node.data+" ");
			if(node.rightNode!=null) {
				myStack.push(node.rightNode);    //深度优先遍历，先遍历左边，后遍历右边,栈先进后出
			}
			if(node.leftNode!=null) {
				myStack.push(node.leftNode);
			}
		}

// 二叉树的广度优先遍历（层序遍历）
public void breadthFirstSearch(TreeNode root) {
    if (root == null) {
        return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        System.out.println(node.val); // 访问当前节点
        if (node.left != null) {
            queue.offer(node.left);
        }
        if (node.right != null) {
            queue.offer(node.right);
        }
    }
}*/
}
