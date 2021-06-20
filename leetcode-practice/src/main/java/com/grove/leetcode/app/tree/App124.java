package com.grove.leetcode.app.tree;

import com.grove.leetcode.model.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 */
public class App124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    private int maxSum(TreeNode root) {
        if (root == null) {
            // 空节点不影响计算结果，返回0
            return 0;
        }

        // 计算左子树能提供的最大值，如果小于0就忽略，当做空节点处理
        int leftMax = Math.max(maxSum(root.left), 0);

        int rightMax = Math.max(maxSum(root.right), 0);

        // 计算携带中间节点能提供的最大值，会有三种情况
        int currentMax = root.val + leftMax + rightMax;

        // 刷新最大值
        max = Math.max(max, currentMax);

        // 携带根节点的两种选择，返回较大的一种
        return root.val + Math.max(leftMax, rightMax);
    }

}
