package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

/**
 * 137. 只出现一次的数字 II
 */
@Component
public class App137 {

    public int singleNumber(int[] nums) {

        int flagOne = 0;
        int flagTow = 0;

        for (int num : nums) {
            flagOne = ~flagTow & (flagOne ^ num);
            flagTow = ~flagOne & (flagTow ^ num);
        }

        return flagOne;
    }

}
