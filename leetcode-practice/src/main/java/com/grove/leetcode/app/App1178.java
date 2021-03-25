package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 1178. 猜字谜
 */
@Component
public class App1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                mask |= (1 << word.charAt(i) - 'a');
            }
            if (Integer.bitCount(mask) <= 7) {
                wordMap.put(mask, wordMap.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> sumList = new ArrayList<>(puzzles.length);
        for (int i = 0; i < puzzles.length; i++) {
            String puzzle = puzzles[i];
            int mask = 0;
            for (int j = 0; j < puzzle.length(); j++) {
                mask |= (1 << puzzle.charAt(j) - 'a');
            }
            int sum = 0;
            // 首字母最高位
            int topInt = (1 << puzzle.charAt(0) - 'a');

            int sub = mask;
            do {
                sub = (sub -1) & mask;
                if ((sub & topInt) != 0 && wordMap.containsKey(sub)) {
                    sum += wordMap.get(sub);
                }
            } while (sub != mask);
            sumList.add(sum);
        }
        return sumList;
    }
}
