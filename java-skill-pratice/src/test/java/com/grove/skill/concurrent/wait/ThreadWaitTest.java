package com.grove.skill.concurrent.wait;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ThreadWaitTest {

    @Autowired
    ThreadWait threadWait;

    @Test
    void start() {
        threadWait.start();
    }
}