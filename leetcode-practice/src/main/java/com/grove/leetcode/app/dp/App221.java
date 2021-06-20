package com.grove.leetcode.app.dp;

public class App221 {
    public int maximalSquare(char[][] matrix) {

        int maxHeight = 0;

        int n = matrix.length;

        int m = matrix[0].length;

        // 为了避免考虑边界问题，初始化长度+1的二维数据，同时也是base case
        int[][] dp = new int[n+1][m+1];


        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                char tmp = matrix[i-1][j-1];

                // 状态转移方程
                if (tmp == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    maxHeight = Math.max(dp[i][j], maxHeight);
                }
            }
        }

        return maxHeight * maxHeight;
    }

    public static void main(String[] args) {
        App221 app221 = new App221();

        char[][] m = new char[2][2];
        m[0] = new char[]{'0','1'};
        m[1] = new char[]{'1','0'};

        app221.maximalSquare(m);
    }
}
