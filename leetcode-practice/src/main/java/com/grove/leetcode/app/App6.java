package com.grove.leetcode.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  z 字形变换
 */
public class App6 {

    public  static String  test(String str, int num){
        if (num < 2) {
            return str;
        }
        List<String> list = new ArrayList<>(num);
        for (int i = 0; i< num; i++) {
            // 初始化
            list.add("");
        }
        int i = 0;
        // 此处用的非常巧妙
        int flag = -1;
        for (char c : str.toCharArray()) {
            list.set(i, list.get(i) + c);

            // 判断是否需要换向
            if (i == 0 || i == num -1) {
                flag = -flag;
            }
            i = i + flag;
        }
        String collect = list.stream().collect(Collectors.joining(""));
        return collect;
    }

}
