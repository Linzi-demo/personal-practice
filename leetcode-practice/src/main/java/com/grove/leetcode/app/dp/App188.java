package com.grove.leetcode.app.dp;

import java.util.Arrays;

public class App188 {

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        Arrays.fill(buy[0], -prices[0]);

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j - 1] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j] + prices[i]);
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        App188 app188 = new App188();
        app188.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
    }
}
