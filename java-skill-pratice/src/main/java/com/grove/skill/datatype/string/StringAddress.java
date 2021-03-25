package com.grove.skill.datatype.string;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StringAddress {

    public void start() {
        String str1 = "test";
        String str2 = "test";

        str2 = str2+"2";


        log.info(str1);
        log.info(str2);
    }
}
