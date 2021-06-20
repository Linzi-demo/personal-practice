package com.grove.leetcode.app.dp;

/**
 * 45. 跳跃游戏 II
 */
public class App45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            int minStep = Integer.MAX_VALUE;
            // 状态转移方程
            for (int j = 0; j < i; j++) {
                if (nums[j] >= (i - j)) {
                    minStep = Math.min(minStep, dp[j] + 1);
                }
            }
            dp[i] = minStep;
        }
        return dp[nums.length - 1];
    }
}
