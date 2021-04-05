package com.grove.leetcode.app.dfs;

/**
 * 494. 目标和
 */
public class App494 {
    int result = 0;

    public int findTargetSumWays(int[] nums, int S) {

        int target = 0;

        dfs(0, nums, target, S);

        return result;
    }

    private void dfs(int i, int[] nums, int target, int S) {
        // 边界条件
        if (i == nums.length) {
            if (target == S) {
                result ++;
            }
            return;
        }

        target += nums[i];
        dfs(i+1, nums, target, S);
        target -= nums[i]*2;
        dfs(i+1, nums, target, S);
        target += nums[i];
    }
}
