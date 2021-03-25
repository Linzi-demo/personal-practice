package com.grove.leetcode.app;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 111. 二叉树的最小深度
 */
public class App111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> set = new HashSet<>();

        queue.add(root);

        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode treeNode = queue.poll();

                if (treeNode.left == null && treeNode.right == null) {
                    return step;
                }

                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
            }
            step++;
        }
        return step;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
