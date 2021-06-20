package com.grove.leetcode.app.dp;

/**
 * 53. 最大子序和
 */
public class App53 {
    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        // base case
        dp[0] = nums[0];

        int result = dp[0];

        for (int i = 1; i < nums.length; i++) {
            //dp 状态转移方程
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            result = Math.max(dp[i], result);
        }

        return result;
    }
}
