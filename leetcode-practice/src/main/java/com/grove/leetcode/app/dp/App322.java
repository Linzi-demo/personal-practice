package com.grove.leetcode.app.dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 */
public class App322 {
    public int coinChange(int[] coins, int amount) {

        int[] arr = new int[amount+1];
        Arrays.fill(arr, amount+1);

        // base函数f(0)=0
        arr[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            // 状态转移方程
            for (int coin : coins) {
                if (i-coin >= 0) {
                    min = Math.min(arr[i-coin], min);
                }
            }
            if (min < amount+1) {
                arr[i] = min+1;
            }
        }
        return arr[amount] < amount+1 ? arr[amount] : -1;

    }

    public static void main(String[] args) {
        App322 app322 = new App322();
        app322.coinChange(new int[]{2}, 3);
    }
}
