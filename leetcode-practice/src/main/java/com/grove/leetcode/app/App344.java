package com.grove.leetcode.app;

/**
 * 344. 反转字符串
 */
public class App344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        for (int left = 0, right = s.length-1; left < right; left++, right--) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
        }
    }
}
