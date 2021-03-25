package com.grove.leetcode.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 833. 字符串中的查找与替换
 */
public class App833 {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        Map<Integer, String[]> map =new HashMap<>();

        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], new String[] {sources[i], targets[i]});
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(Integer::compareTo);
        List<String> result = new ArrayList<>();
        int start = 0;
        for (Integer i : list) {
            String source = map.get(i)[0];
            String target = map.get(i)[1];

            int index = S.indexOf(source, i);
            if (index == i) {
                result.add(S.substring(start, index));
                result.add(target);
                start = index + source.length();
            }
        }

        result.add(S.substring(start));

        return result.stream().collect(Collectors.joining());
    }


}
