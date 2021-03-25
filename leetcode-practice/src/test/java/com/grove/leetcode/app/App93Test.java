package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App93Test {

    @Autowired
    App93 app93;

    @Test
    void restoreIpAddresses() {
        app93.restoreIpAddresses("010010");
    }
}