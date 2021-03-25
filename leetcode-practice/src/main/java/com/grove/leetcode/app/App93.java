package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 93. 复原 IP 地址
 */
@Component
public class App93 {
    public List<String> restoreIpAddresses(String s) {

        if(s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();

        dfs(s, 0, 4, path, result);

        return result;
    }

    private void dfs(String s, int start, int maxDepth, Deque<String> path, List<String> result) {
        int length = s.length();
        if (maxDepth == 0) {
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int i = start; i < start+3; i++) {
            if (i >= length) {
                return;
            }
            if (length - i > maxDepth*3) {
                continue;
            }

            String substring = s.substring(start, i + 1);
            int num = Integer.parseInt(substring);
            if (num > 255) {
                return;
            }
            path.addLast(substring);
            dfs(s, i+1, maxDepth-1, path, result);
            path.removeLast();
            if (num == 0) {
                return;
            }
        }
    }
}
