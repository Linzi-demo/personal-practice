package com.grove.skill.datatype.string;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StringAddressTest {

    @Autowired
    StringAddress stringAddress;
    @Test
    void start() {
        stringAddress.start();
    }
}