package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App415Test {

    @Autowired
    App415 app415;

    @Test
    void addStrings() {
        app415.addStrings("9", "99");
    }
}