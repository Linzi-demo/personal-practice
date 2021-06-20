package com.grove.leetcode.app.dp;

public class App152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        // 初始化状态转移数组
        int[][] dp = new int[nums.length][2];
        // base case
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 由于负负得正，所以每次需要记录当前能得到的最大值和最小值
            dp[i][0] = Math.min(dp[i-1][1]*nums[i],Math.min(dp[i-1][0]*nums[i], nums[i]));
            dp[i][1] = Math.max(dp[i-1][1]*nums[i],Math.max(dp[i-1][0]*nums[i], nums[i]));
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }
}
