package com.grove.leetcode.app;

import java.util.Stack;

/**
 * 32. 最长有效括号
 */
public class App32 {
    public int longestValidParentheses(String s) {
        int sum = 0;

        if (s == null || s.length() == 0) {
            return sum;
        }

        char[] chars = s.toCharArray();
        int split = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i=0; i<chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    sum = Math.max(sum, i - stack.peek());
                }
            }
        }
        return sum;
    }
}
