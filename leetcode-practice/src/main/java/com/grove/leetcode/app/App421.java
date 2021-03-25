package com.grove.leetcode.app;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. 数组中两个数的最大异或值
 */
public class App421 {
    public int findMaximumXOR(int[] nums) {
        int result = 0;
        int mask = 0;

        for (int i = 30; i>=0; i--) {
            // 获取掩码表
            mask = mask | 1 << i;

            // 前缀列表
            Set<Integer> preList = new HashSet<>();
            for (int num : nums) {
                preList.add(num & mask);
            }

            int temp = result | 1<<i;
            for (int num : preList) {
                if (preList.contains(num ^ temp)) {
                    result = temp;
                    break;
                }
            }
        }
        return result;
    }
}
