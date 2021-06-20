package com.grove.leetcode.app.dp;

/**
 * 72. 编辑距离
 */
public class App72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 处理空串的情况
        if (n * m == 0) {
            return n + m;
        }

        int[][] dp = new int[n+1][m+1];

        // 初始化，0位为空串，向空串进行转换，就是对应字符串的长度
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m+1; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                // 不相等时，有三种操作可以选择
                int add = dp[i][j-1];
                int remove = dp[i-1][j];
                int replace = dp[i-1][j-1];

                dp[i][j] = Math.min(add, Math.min(remove, replace)) + 1;
            }
        }

        return dp[n][m];
    }
}
