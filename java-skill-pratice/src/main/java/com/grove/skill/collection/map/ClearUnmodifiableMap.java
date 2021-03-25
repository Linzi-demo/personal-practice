package com.grove.skill.collection.map;

import com.sun.javafx.UnmodifiableArrayList;
import com.sun.javafx.collections.UnmodifiableObservableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClearUnmodifiableMap {

    public void start() {
        String[] arr = new String[1];
        UnmodifiableArrayList arrayList = new UnmodifiableArrayList(arr, 1);
        arrayList.add("1");
        log.info(arrayList.toString());
        arrayList.clear();
        log.info(arrayList.toString());
    }


}
