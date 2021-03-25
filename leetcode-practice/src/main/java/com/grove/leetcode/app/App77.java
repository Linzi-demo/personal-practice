package com.grove.leetcode.app;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 */
public class App77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (k == 0 || n < k) {
            return result;
        }

        Deque<Integer> path =new ArrayDeque<>();

        dfs(n, 1, k, path, result);

        return result;
    }

    private void dfs(int num, int start, int max, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == max) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i=start; i<=num-max+1; i++){
            if (path.size() == 0 && i > num-max+1) {
                return;
            }
            path.add(i);

            dfs(num, i+1, max, path, result);

            path.removeLast();
        }
    }
}
