package com.grove.leetcode.app.dp;

import com.grove.leetcode.model.TreeNode;

/**
 * 337. 打家劫舍 III
 */
public class App337 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = dp(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dp(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = dp(root.left);
        int[] right = dp(root.right);

        int[] result = new int[2];

        // 当前节点如果不选，那么他能偷到的最大值 = 左右节点能偷到的最大值之和
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 当前节点如果偷，那么他偷到的最大值 = 左右节点不偷的最大值 + 当前节点的值
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
