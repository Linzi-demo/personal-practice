package com.grove.leetcode.app.dp;

/**
 * 377. 组合总和 Ⅳ
 */
public class App377 {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0 || nums == null) {
            return 1;
        }
        // 定义状态转移方程
        // dp[i] 为目标值为i的组合数
        int[] dp = new int[target+1];

        // base case
        // 目标值为0时，没有可选的值，所以只有一种情况
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            // 状态转移方程
            for (int num : nums) {
                if (num <= i) {
                    dp[i]  += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
