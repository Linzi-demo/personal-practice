package com.grove.leetcode.app;

import java.util.*;

/**
 *90. 子集 II
 */
public class App90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, path, result);

        return result;
    }

    private void dfs(int[] nums, int start, Deque<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for(int i = start; i<nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            path.addLast(nums[i]);
            dfs(nums, i+1, path, result);
            path.removeLast();
        }
    }
}

