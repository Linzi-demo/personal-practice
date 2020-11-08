package com.grove.leetcode.app;

/**
 * 最长回文子串
 */
public class App5 {

    public static String start(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        if (length < 2) {
            return str;
        }

        char[] chars = str.toCharArray();

        boolean[][] dpArr = new boolean[length][length];
        int maxLength = 1;
        int beginIndex = 0;
        for (int i = 1; i<length; i++) {
            for (int j = 0; j< i; j++) {
                if (chars[i] != chars[j]) {
                    dpArr[j][i] = false;
                } else {
                    if (i - j + 1 <= 3) {
                        dpArr[j][i] = true;
                    } else {
                        dpArr[j][i] = dpArr[j+1][i-1];
                    }
                }

                if (dpArr[j][i] && i - j +1 > maxLength) {
                    maxLength = i - j + 1;
                    beginIndex = j;
                }
            }
        }

        return str.substring(beginIndex, beginIndex + maxLength);
    }

}
