package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 127. 单词接龙
 */
@Component
public class App127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (wordSet.isEmpty() || !wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        Set<String> visisted = new HashSet<>();
        visisted.add(beginWord);

        Set<Character> characters = new HashSet<>();
        wordSet.forEach(word -> {
            for (char ch : word.toCharArray()) {
                characters.add(ch);
            }
        });
        int step = 1;
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int j = 0; j < size; j++) {
                String poll = queue.poll();
                char[] chars = poll.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (Character ch : characters) {
                        char temp = chars[i];
                        chars[i] = ch;
                        String str = new String(chars);
                        chars[i] = temp;
                        if (visisted.contains(str) || !wordSet.contains(str)) {
                            continue;
                        }
                        if (str.equals(endWord)) {
                            return step+1;
                        }
                        queue.add(str);
                        visisted.add(str);
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
