package com.grove.skill.collection.list;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class ListAdd {

    public void start() {
        List<String> list = new ArrayList<>();
        // 运行时异常IndexOutOfBoundsException
        list.add(2, "test");
        log.info(list.toString());
    }
}
