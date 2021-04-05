package com.grove.leetcode.app.point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }

            if (nums[first] > 0) {
                break;
            }

            List<List<Integer>> twoSumResult = twoSum(nums,first+1, nums.length-1, first);
            result.addAll(twoSumResult);
        }

        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int second, int third, int first) {
        List<List<Integer>> result = new ArrayList<>();

        int start = second;
        int target = -nums[first];
        int end = third;
        for (; start < nums.length; start++) {
            if (start > second && nums[start] == nums[start-1]) {
                continue;
            }

            while (start < end && nums[start] + nums[end] > target) {
                end--;
            }

            if (start == end) {
                break;
            }

            if (nums[start] + nums[end] == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[start]);
                temp.add(nums[end]);
                temp.add(nums[first]);

                result.add(temp);
            }
        }
        return result;
    }


}
