package com.grove.leetcode.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 */
public class App17 {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        dfs(digits, 0, new StringBuilder(), map, result);

        return result;
    }

    private void dfs(String digits, int depth, StringBuilder path, Map<String, String> map, List<String> result) {
        if (depth == digits.length()) {
            result.add(path.toString());
            return;
        }

        char current = digits.charAt(depth);

        String str = map.get(String.valueOf(current));

        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            dfs(digits, depth+1, path, map, result);
            path.deleteCharAt(path.length()-1);
        }
    }
}
