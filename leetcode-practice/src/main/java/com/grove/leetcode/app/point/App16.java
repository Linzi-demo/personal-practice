package com.grove.leetcode.app.point;

import java.util.Arrays;

public class App16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int cur = nums[i];
            int start = i+1;
            int end = nums.length-1;
            while (start < end) {
                int sum = cur + nums[start] + nums[end];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    result = sum;
                }
                if (sum == target) {
                    return result;
                }
                if (sum > target) {
                    end--;
                    continue;
                }
                if (sum < target) {
                    start++;
                    continue;
                }
            }
        }
        return result;
    }
}
