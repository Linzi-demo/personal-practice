package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App40Test {

    @Autowired
    App40 app40;

    @Test
    void combinationSum2() {
        int[] nums = new int[]{10,1,2,7,6,1,5};

        app40.combinationSum2(nums, 8);
    }
}