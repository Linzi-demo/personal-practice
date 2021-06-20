package com.grove.leetcode.app.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题
 */
public class App354 {

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    // 第一位升序排列
                    return o1[0] - o2[0];
                } else {
                    // 第二位降序排序，可以解决第一位相同的问题
                    return o2[1] - o1[1];
                }
            }
        });

        // 排序后就转变为最长升序串问题
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        int result = 1;
        for (int i = 1; i<envelopes.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    max = Math.max(max, dp[j]+1);
                }
            }
            dp[i] = max;
            result = Math.max(result, max);
        }

        return result;
    }
}
