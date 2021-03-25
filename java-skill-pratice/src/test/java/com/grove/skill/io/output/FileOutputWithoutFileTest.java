package com.grove.skill.io.output;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileOutputWithoutFileTest {

    @Autowired
    FileOutputWithoutFile fileOutputWithoutFile;

    @Test
    void start() {
        fileOutputWithoutFile.start();
    }
}