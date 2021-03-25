package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App260Test {

    @Autowired
    App260 app260;

    @Test
    void singleNumber() {

        int[] nums = new int[] {1,2,1,3,2,5};

        app260.singleNumber(nums);

    }
}