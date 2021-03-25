package com.grove.skill.datatype.integer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IntegerPractice {

    public void start() {
        Integer integer = 256;

        boolean flag=integer == Integer.valueOf(256);
        log.info("result is {}", flag);
    }

}
