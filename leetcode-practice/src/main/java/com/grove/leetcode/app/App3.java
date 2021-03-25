package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class App3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 使用hash表记录每个字符最新出现的位置
        Map<Character, Integer> map = new HashMap<>();
        int pre = 0;
        int last = 0;
        int maxLength = 1;
        while (last < s.length()) {
            char ch = s.charAt(last);

            if (map.containsKey(ch)) {
                pre = Math.max(map.get(ch)+1, pre);
            }
            maxLength = Math.max(maxLength, last - pre + 1);
            map.put(ch, last);
            last ++;
        }

        return maxLength;

    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}
