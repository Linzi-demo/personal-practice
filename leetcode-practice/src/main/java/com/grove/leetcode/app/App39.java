package com.grove.leetcode.app;

import java.util.*;

/**
 * 39. 组合总和
 */
public class App39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }
        // 剪枝提速，先排序
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, target, path, result);

        return result;
    }

    private void dfs(int[] candidates, int start, int target, Deque<Integer> path, List<List<Integer>> result) {
        // 判断边界值，为负数时是无效路径，为0时有效
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                // 如果目标值减去当前值小于0就直接返回，因为是排序过得，所以后面的值肯定不符合
                return;
            }

            path.add(candidates[i]);

            dfs(candidates, i, target - candidates[i], path, result);

            // 状态回溯
            path.removeLast();
        }
    }
}
