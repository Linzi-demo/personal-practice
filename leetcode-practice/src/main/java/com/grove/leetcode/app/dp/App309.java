package com.grove.leetcode.app.dp;

/**
 * 309. 最佳买卖股票时机含冷冻期
 */
public class App309 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        //只要维护前一天的数据即可
        // 每天会有三种情况
        int haveOne = -prices[0];
        int noneAndCold = 0;
        int noneAndNoCold = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentHaveOne = Math.max(haveOne, noneAndNoCold - prices[i]);
            int currentNoneAndCold = haveOne + prices[i];
            int currentNoneAndNoCold = Math.max(noneAndCold, noneAndNoCold);

            haveOne = currentHaveOne;
            noneAndCold = currentNoneAndCold;
            noneAndNoCold = currentNoneAndNoCold;
        }

        return Math.max(noneAndCold, noneAndNoCold);
    }

    public static void main(String[] args) {
        App309 app309 = new App309();

        app309.maxProfit(new int[]{1,2,3,0,2});
    }
}
