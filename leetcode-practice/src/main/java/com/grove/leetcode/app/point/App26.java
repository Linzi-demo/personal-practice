package com.grove.leetcode.app.point;

/**
 * 26. 删除有序数组中的重复项
 */
public class App26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[slow+1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow+1;
    }
}
