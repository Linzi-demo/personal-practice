package com.grove.skill.controller.switchtype;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SwitchWithoutBreakTest {

    @Autowired
    SwitchWithoutBreak switchWithoutBreak;

    @Test
    void start() {
        switchWithoutBreak.start(2);
    }
}