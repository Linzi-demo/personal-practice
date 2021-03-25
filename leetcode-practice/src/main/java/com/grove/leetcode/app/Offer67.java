package com.grove.leetcode.app;

import java.util.Stack;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 */
public class Offer67 {

    public int strToInt(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        int result = 0;
        int max = Integer.MAX_VALUE / 10;

        String trim = str.trim();
        int flag = 1;
        int start = 0;
        char first = trim.charAt(0);
        if (first == '-') {
            flag = -1;
            start = 1;
        } else if (first == '+') {
            start = 1;
        }
        char[] chars = trim.toCharArray();
        for (int i = start; i<chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                break;
            }
            if (result > max || (result == max && chars[i] > '7')) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + (chars[i] - '0');
        }

        return flag * result;
    }


}
