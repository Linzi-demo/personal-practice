package com.grove.leetcode.app.dp;

/**
 * 1277. 统计全为 1 的正方形子矩阵
 */
public class App1277 {

    public int countSquares(int[][] matrix) {
        int sum = 0;

        int n = matrix.length;
        int m = matrix[0].length;

        // 定义dp数组，这里数组的大小要比输入数据大一个，这样可以避免考虑边界值，
        // 同时int数组所有数据默认值为0,这样base case也有了
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int tmp = matrix[i-1][j-1];

                // 状态转移方程
                if (tmp == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    sum += dp[i][j];
                }
            }
        }

        return sum;
    }


}
