package com.grove.leetcode.app.dp;

/**
 * 300. 最长递增子序列
 */
public class App300 {

    public int lengthOfLIS(int[] nums) {
        int result = 1;

        int[] dp = new int[nums.length];
        // base case
        dp[0]=1;

        for (int i=1; i < nums.length; i++) {
            int max = 1;
            // 状态转移方程
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]+1);
                }
            }
            dp[i] = max;
            result = Math.max(result, max);
        }
        return result;
    }

}
