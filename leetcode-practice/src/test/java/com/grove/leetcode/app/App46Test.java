package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App46Test {

    @Autowired
    App46 app46;

    @Test
    void permute() {
        int[] nums = new int[] {1,2,3};

        app46.permute(nums);

    }
}