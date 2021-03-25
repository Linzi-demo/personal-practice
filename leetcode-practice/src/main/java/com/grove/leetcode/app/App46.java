package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 */
@Component
public class App46 {
    public List<List<Integer>> permute(int[] nums) {
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        boolean[] used = new boolean[nums.length];

        List<Integer> path = new ArrayList<>();

        dfs(nums, 0, used, path, result);

        return result;
    }

    private void dfs(int[] nums, int depth, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        // 临界状态，记录结果，返回
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // 遇到未使用的节点，添加到路径，标记为已使用
                path.add(nums[i]);
                used[i] = true;

                // 继续往下一层
                dfs(nums, depth + 1, used, path, result);

                // 下一层返回后，要进行回溯，清楚路径和状态
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
