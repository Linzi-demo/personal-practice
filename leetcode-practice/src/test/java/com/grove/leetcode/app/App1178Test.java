package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App1178Test {

    @Autowired
    App1178 app1178;

    @Test
    void findNumOfValidWords() {
        String[] words = new String[]{"apple","pleas","please"};

        String[] puzzals = new String[]{"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"};

        app1178.findNumOfValidWords(words, puzzals);
    }
}