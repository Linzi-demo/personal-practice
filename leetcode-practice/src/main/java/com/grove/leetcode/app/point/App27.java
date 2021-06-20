package com.grove.leetcode.app.point;

/**
 * 27. 移除元素
 */
public class App27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }
        int start = 0;
        int end = nums.length-1;

        for (; start <= end; start++) {
            if (nums[start] != val) {
                continue;
            }
            while (end >= start && nums[end] == val) {
                end--;
            }
            if (end < start) {
                break;
            }
            nums[start] = nums[end];
            end--;
        }
        return end+1;
    }
}
