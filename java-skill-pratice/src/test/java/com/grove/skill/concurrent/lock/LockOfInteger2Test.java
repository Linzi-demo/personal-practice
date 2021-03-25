package com.grove.skill.concurrent.lock;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LockOfInteger2Test {

    @Test
    void start() {
        LockOfInteger2 lockOfInteger2 = new LockOfInteger2();
        lockOfInteger2.start();
    }
}