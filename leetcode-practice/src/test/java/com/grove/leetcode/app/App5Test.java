package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App5Test {

    @Test
    void start() {
        String babadba = App5.start("ac");
        System.out.printf(babadba);
    }
}