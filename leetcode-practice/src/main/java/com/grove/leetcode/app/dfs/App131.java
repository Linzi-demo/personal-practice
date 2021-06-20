package com.grove.leetcode.app.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class App131 {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        boolean[][] isCycleStr = new boolean[s.length()][s.length()];
        isCycleStr[0][0] = true;
        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i ++) {
            for (int j = 0; j <= i; j++) {
                if (chars[j] == chars[i] && (i-j < 2 || isCycleStr[j+1][i-1])) {
                    isCycleStr[j][i] = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, result, stack, isCycleStr);

        return result;
    }

    private void dfs(String s, int depth, List<List<String>> result, Deque<String> stack, boolean[][] isCycleStr) {
        // 递归边界
        if (depth == s.length()) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = depth; i < s.length(); i++) {
            if (isCycleStr[depth][i]) {
                stack.addLast(s.substring(depth, i+1));
                dfs(s, i+1, result, stack, isCycleStr);
                stack.removeLast();
            }
        }
    }
}
