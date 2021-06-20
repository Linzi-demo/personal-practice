package com.grove.leetcode.app.dp;

/**
 * 64. 最小路径和
 */
public class App64 {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        // 初始化边界值
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // 状态转移方程
                // 对于对[i,j]个节点，到达这个节点的路径只有两种选择
                // 1. 从上方来，上面节点的最小路径和就是dp[i-1][j]
                // 2. 从左边来，左边节点的最小路径和就是dp[i][j-1]
                // 选择其中较小的
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[n-1][m-1];
    }
}
