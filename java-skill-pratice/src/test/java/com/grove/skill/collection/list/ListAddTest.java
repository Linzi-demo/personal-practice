package com.grove.skill.collection.list;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ListAddTest {

    @Test
    void start() {
        ListAdd listAdd = new ListAdd();
        listAdd.start();
    }
}