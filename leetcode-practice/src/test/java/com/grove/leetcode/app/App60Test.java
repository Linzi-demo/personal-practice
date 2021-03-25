package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App60Test {

    @Autowired
    App60 app60;

    @Test
    void getPermutation() {
        app60.getPermutation(3,3);
    }
}