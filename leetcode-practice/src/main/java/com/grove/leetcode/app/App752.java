package com.grove.leetcode.app;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 752. 打开转盘锁
 */
public class App752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Set<String> deads = Arrays.stream(deadends).collect(Collectors.toSet());
        int step = 0;

        queue.add("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();

                if (deads.contains(poll)) {
                    continue;
                }
                if (target.equals(poll)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String upOne = upOne(poll, j);
                    if (!visited.contains(upOne)) {
                        queue.add(upOne);
                        visited.add(upOne);
                    }
                    String downOne = downOne(poll, j);
                    if (!visited.contains(downOne)) {
                        queue.add(downOne);
                        visited.add(downOne);
                    }

                }
            }
            step++;

        }
        return -1;
    }

    private String upOne(String src, int index) {
        char[] chars = src.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] += 1;
        }

        return new String(chars);
    }

    private String downOne(String src, int index) {
        char[] chars = src.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] -= 1;
        }

        return new String(chars);
    }
}
