package com.grove.leetcode.app;

import java.util.ArrayList;
import java.util.List;

/**
 * 722. 删除注释
 */
public class App777 {


    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean isBlock = false;

        StringBuilder lineBuilder = new StringBuilder();
        for (String line : source) {
            int i = 0;
            char[] chars = line.toCharArray();

            if (!isBlock) {
                lineBuilder = new StringBuilder();
            }
            while (i < line.length()) {
                if (!isBlock && i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '*') {
                    isBlock = true;
                    i++;
                } else if (isBlock && i + 1 < chars.length && chars[i] == '*' && chars[i + 1] == '/') {
                    isBlock = false;
                    i++;
                } else if (!isBlock && i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '/') {
                    break;
                } else if (!isBlock) {
                    lineBuilder.append(chars[i]);
                }
                i++;
            }
            if (!isBlock && lineBuilder.length() > 0) {
                result.add(lineBuilder.toString());
            }
        }
        return result;
    }


}
