package com.grove.leetcode.app.dp;

import java.util.Arrays;

/**
 * 62. 不同路径
 */
public class App62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // 初始化边界值
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 状态转移方程
                // 当前节点的路径总数= 上方节点的路径总数+左方节点的路径总数
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
