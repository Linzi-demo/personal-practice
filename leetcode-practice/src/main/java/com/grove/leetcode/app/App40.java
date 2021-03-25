package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 40. 组合总和 II
 */
@Component
public class App40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }

        // 排序，为了剪枝
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, target, path, result);

        return result;
    }

    private void dfs(int[] candidates, int start, int target, Deque<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            // 剪枝
            if (target - candidates[i] < 0) {
                return;
            }
            // 剪枝去重
            if(i > start && candidates[i] == candidates[i-1]) {
                continue;
            }

            path.add(candidates[i]);

            dfs(candidates, i+1, target-candidates[i], path, result);

            path.removeLast();
        }
    }
}
