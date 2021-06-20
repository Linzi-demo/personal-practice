package com.grove.leetcode.app.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * 91. 解码方法
 */
public class App91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            set.add(i+"");
        }

        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            // 当前节点包含两种状态
            // 当前节点单独作为一个解码
            int count1 = set.contains(s.substring(i, i+1)) ? dp[i-1] : 0;
            // 当前节点和前一个节点组成解码
            int count2 = 0;

            if (set.contains(s.substring(i-1, i+1))) {
                if (i == 1) {
                    count2 = 1;
                } else {
                    count2 = dp[i-2];
                }
            }
            dp[i] = count1+count2;
        }

        return dp[s.length()-1];
    }

}
