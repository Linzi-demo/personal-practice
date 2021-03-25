package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

/**
 * 80. 删除排序数组中的重复项 II
 */
@Component
public class App80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 1; // 第一位不用考虑
        int count = 1;

        for (int i = 1; i< nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <=2) {
                nums[result++] = nums[i];
            }
        }

        return result;
    }
}
