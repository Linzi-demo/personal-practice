package com.grove.leetcode.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class App1125Test {

    @Autowired
    App1125 app1125;

    @Test
    void smallestSufficientTeam() {
        String[] skills = new String[] {"algorithms","math","java","reactjs","csharp","aws"};

        List<List<String>> people = new ArrayList<>();
        people.add(Arrays.asList("algorithms","math","java"));
        people.add(Arrays.asList("algorithms","math","reactjs"));
        people.add(Arrays.asList("java","csharp","aws"));
        people.add(Arrays.asList("reactjs","csharp"));
        people.add(Arrays.asList("csharp","math"));
        people.add(Arrays.asList("aws","java"));

        app1125.smallestSufficientTeam(skills, people);
    }
}