package com.grove.leetcode.app.point;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 340. 至多包含 K 个不同字符的最长子串
 */
public class App340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k == 0) {
            return 0;
        }
        if (s.length() < k+1) {
            return s.length();
        }

        int max = 0;
        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (; right < s.length(); right++) {
            map.put(s.charAt(right), right);

            if (map.size() == k+1) {
                // 删除最左边的元素，保证map中只有两个元素
                Integer min = Collections.min(map.values());
                left = min + 1;
                map.remove(s.charAt(min));
            } else {
                max = Math.max(max, right-left + 1);
            }
        }
        return max;
    }
}
