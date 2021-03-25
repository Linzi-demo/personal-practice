package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

/**
 *14. 最长公共前缀
 */
@Component
public class App14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char first = strs[0].charAt(i);
            for (String str : strs) {
                if (i == str.length() || str.charAt(i) != first) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
