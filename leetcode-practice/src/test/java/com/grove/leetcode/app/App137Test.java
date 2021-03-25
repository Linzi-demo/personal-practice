package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App137Test {

    @Autowired
    App137 app137;

    @Test
    void singleNumber() {
        int[] nums = new int[] {0,0,1,0};

        int i = app137.singleNumber(nums);
        Assert.isTrue(i == 1, "ok");


    }
}