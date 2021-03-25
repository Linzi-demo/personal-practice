package com.grove.leetcode.app;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 78. 子集
 */
public class App78 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        dfs(nums, 0, path, result);

        return result;
    }

    private void dfs(int[] nums, int start, Deque<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        if (start == nums.length) {
            return;
        }

        for(int i=start; i< nums.length; i++) {
            path.addLast(nums[i]);

            dfs(nums, i+1, path, result);

            path.removeLast();
        }
    }
}
