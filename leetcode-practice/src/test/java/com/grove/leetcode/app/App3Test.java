package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class App3Test {

    @Autowired
    App3 app3;

    @Test
    void lengthOfLongestSubstring() {
        int length = app3.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(length);

    }
}