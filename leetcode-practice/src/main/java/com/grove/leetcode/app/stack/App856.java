package com.grove.leetcode.app.stack;

import java.sql.SQLOutput;
import java.util.Stack;

/**
 * 856. 括号的分数
 */
public class App856 {
    public int scoreOfParentheses(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        stack.push(String.valueOf(chars[0]));
        int index = 1;
        while (index < chars.length) {
            if (chars[index] == '(') {
                stack.push(String.valueOf(chars[index]));
                index++;
                continue;
            }
            int sum = 1;
            String temp = stack.pop();
            if (!"(".equals(temp)) {
                sum = Integer.parseInt(temp) * 2;
                stack.pop();
            }
            pushInt(stack, sum);
            index++;
        }
        return Integer.parseInt(stack.pop());
    }

    private void pushInt(Stack<String> stack, int sum) {
        if (stack.isEmpty() || "(".equals(stack.peek())) {
            stack.push(String.valueOf(sum));
        } else {
            String left = stack.pop();
            int count = Integer.parseInt(left) + sum;
            stack.push(String.valueOf(count));
        }
    }

    public static void main(String[] args) {
        App856 app856 = new App856();
        System.out.println(app856.scoreOfParentheses("0"));
    }
}
