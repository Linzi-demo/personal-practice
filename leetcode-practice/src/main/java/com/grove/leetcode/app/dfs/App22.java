package com.grove.leetcode.app.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class App22 {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        StringBuilder stringBuilder = new StringBuilder();

        List<String> result = new ArrayList<>();

        dfs(result, stringBuilder, 0, 0, n);

        return result;
    }

    private void dfs(List<String> result, StringBuilder stringBuilder, int open, int close, int n) {
        if (stringBuilder.length() == n*2) {
            result.add(stringBuilder.toString());
        }
        if (open < n) {
            stringBuilder.append("(");
            dfs(result, stringBuilder, open + 1, close, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (close < open) {
            stringBuilder.append(")");
            dfs(result, stringBuilder, open, close + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
