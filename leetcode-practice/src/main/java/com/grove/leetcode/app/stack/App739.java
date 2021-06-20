package com.grove.leetcode.app.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 739. 每日温度
 */
public class App739 {
    public int[] dailyTemperatures(int[] T) {
        if (T == null) {
            return null;
        }
        int[] result = new int[T.length];
        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty() || T[stack.peek()] >= T[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                    Integer pop = stack.pop();

                    result[pop] = i - pop;
                }
                stack.push(i);
            }
        }
        return result;
    }
}
