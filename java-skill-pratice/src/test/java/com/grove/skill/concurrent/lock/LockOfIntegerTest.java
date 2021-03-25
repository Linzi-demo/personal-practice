package com.grove.skill.concurrent.lock;

import com.grove.skill.concurrent.lock.LockOfInteger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LockOfIntegerTest {

    @Autowired
    LockOfInteger lockOfInteger;

    @Test
    void start() {
        lockOfInteger.start();
    }

    @Test
    void start2() {
        lockOfInteger.start2();
    }
}