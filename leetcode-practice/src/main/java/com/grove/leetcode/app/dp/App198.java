package com.grove.leetcode.app.dp;

/**
 * 198. 打家劫舍
 */
public class App198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 状态转移数据+base case
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];

        for (int i = 2; i < dp.length; i++) {
            int tmp = nums[i-1];
            // 对于当前节点有两种选择
            // 1. 选择当前节点，那么i-1个就不能选择，最大值就是i-2节点能取到的最大值加上当前值
            // 2. 如果不选择当前节点，那么就可以选择i-1节点，最大就是i-1节点能取到的最大值
            // 取两种情况中较大的一种
            dp[i] = Math.max(dp[i-2]+tmp, dp[i-1]);
        }
        return dp[nums.length];
    }
}
