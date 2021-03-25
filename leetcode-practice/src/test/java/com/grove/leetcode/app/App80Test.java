package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App80Test {

    @Autowired
    App80 app80;


    @Test
    void removeDuplicates() {
        app80.removeDuplicates(new int[]{1,1,1,1,2,2,3});
    }
}