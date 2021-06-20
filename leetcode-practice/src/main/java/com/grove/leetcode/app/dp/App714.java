package com.grove.leetcode.app.dp;

/**
 * 714. 买卖股票的最佳时机含手续费
 */
public class App714 {


    public int maxProfit(int[] prices, int fee) {
        // 定义状态转移方程，由于当前的最大收益只依赖前一天的情况，这里只需要维护前一天的数据即可
        // base
        // 当前手上存在一支股票的最大收益
        int havePrice = -prices[0];
        // 当前手上不存在股票的最大收益
        int nonePrice = 0;

        for (int i =0; i< prices.length; i++) {
            int currentHave = Math.max(havePrice, nonePrice-prices[i]);
            int currentNone = Math.max(havePrice+prices[i]-fee, nonePrice);

            havePrice = currentHave;
            nonePrice = currentNone;
        }

        return nonePrice;
    }

}
