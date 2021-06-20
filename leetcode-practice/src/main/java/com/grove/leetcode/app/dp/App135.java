package com.grove.leetcode.app.dp;

/**
 *135. 分发糖果
 */
public class App135 {
    public int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int bp = 1;
        int pre = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] <= ratings[i-1]) {
                ratings[i] = 1;
                if (pre > 1) {
                    bp = bp + 1;
                } else {
                    bp = bp + 1 + i;
                }
            } else {

            }
        }
        return 0;

    }

}
