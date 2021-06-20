package com.grove.leetcode.app.point;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 159. 至多包含两个不同字符的最长子串
 */
public class App159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() < 3) {
            return s.length();
        }

        int max = 0;
        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (; right < s.length(); right++) {
            map.put(s.charAt(right), right);

            if (map.size() == 3) {
                // 删除最左边的元素，保证map中只有两个元素
                Integer min = Collections.min(map.values());
                left = min + 1;
                map.remove(s.charAt(min));
            } else {
                max = Math.max(max, right-left);
            }
        }
        return max;
    }
}
