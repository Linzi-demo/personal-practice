package com.grove.leetcode.app.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 */
public class App139 {
    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0) {
            return false;
        }

        boolean[] dp = new boolean[s.length() + 1];

        // base case
        dp[0] = true;

        Set<String> set = new HashSet<>(wordDict);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                // 状态转移方程，此处较难理解
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
