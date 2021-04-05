package com.grove.leetcode.app.point;

/**
 * 11. 盛最多水的容器
 */
public class App11 {

    public int maxArea(int[] height) {
        int maxArea = 0;

        // 双指针指向头部
        int first = 0;

        // 双指针指向结尾
        int last = height.length - 1;

        while (first < last) {
            // 当前指向的位置所占得面积
            int currentSum = Math.min(height[first], height[last]) * (last - first);
            // 取较大值
            maxArea = Math.max(maxArea, currentSum);

            // 双指针移动规则，始终是短板的一边向内侧移动一位
            if (height[first] <= height[last]) {
                first++;
            } else {
                last--;
            }
        }
        return maxArea;
    }
}
