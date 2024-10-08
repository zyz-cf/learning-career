package com.zyz.basic.exercises;

import com.zyz.algorithm.practice.search.SearchAlgorithm;
import com.zyz.algorithm.practice.tree.BinaryTreeAlgorithm;
import com.zyz.algorithm.practice.tree.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchAlgorithmTest {

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

    @Test
    @DisplayName("验证二叉树高度算法成功")
    public void testBinaryTreeHeight() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        four.left = eight;

        Assertions.assertEquals(4, BinaryTreeAlgorithm.treeHeight(one));
        Assertions.assertEquals(4, BinaryTreeAlgorithm.treeWeight(one));
    }

    @Test
    @DisplayName("验证二叉树层次遍历算法成功")
    public void testBinaryTreeLevelTraversal() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        four.left = eight;
        four.right = nine;

        System.out.print("层次遍历：");
        BinaryTreeAlgorithm.treeLevelTraversal(one);
        System.out.println();
        System.out.println("广度优先遍历：" + BinaryTreeAlgorithm.treeLevelTraversalImprove(one));
        System.out.println("蛇形遍历：" + BinaryTreeAlgorithm.treeLevelZigzagLevelOrder(one));
        System.out.print("深度优先遍历：");
        BinaryTreeAlgorithm.treeDFSTraversal(one);
        System.out.println();
        System.out.print("前序遍历：");
        BinaryTreeAlgorithm.treePreOrderTraversal(one);
        System.out.println();
        System.out.print("中序遍历：");
        BinaryTreeAlgorithm.treeMidOrderTraversal(one);
        System.out.println();
        System.out.print("后续遍历：");
        BinaryTreeAlgorithm.treePostOrderTraversal(one);


    }
}
