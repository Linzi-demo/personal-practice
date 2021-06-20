package com.grove.leetcode.app.point;

public class App28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (indexOf(haystack, needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean indexOf(String haystack, String needle, int start) {
        int end = start + needle.length();
        if (end > haystack.length()) {
            return false;
        }
        String substring = haystack.substring(start, end);
        return substring.endsWith(needle);
    }

    public static void main(String[] args) {
        App28 app28 = new App28();
        app28.strStr("hello", "ll");
    }
}
