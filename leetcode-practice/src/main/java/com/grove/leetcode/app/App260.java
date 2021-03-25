package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

/**
 * 260. 只出现一次的数字 III
 */
@Component
public class App260 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int mask = xor & (-xor);

        int[] result = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }

}
