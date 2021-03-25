package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App127Test {

    @Autowired
    App127 app127;

    @Test
    void ladderLength() {
        app127.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
    }
}