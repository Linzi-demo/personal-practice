package com.grove.leetcode.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 */
public class App47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        dfs(nums, 0, used, path, result);

        return result;
    }

    private void dfs(int[] nums, int depth, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);

                dfs(nums, depth+1, used, path, result);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
