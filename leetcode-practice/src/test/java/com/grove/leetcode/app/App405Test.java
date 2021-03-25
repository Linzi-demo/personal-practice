package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App405Test {

    @Autowired
    App405 app405;

    @Test
    void toHex() {
        app405.toHex(26);
    }
}