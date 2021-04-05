package com.grove.leetcode.app.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 394. 字符串解码
 */
public class App394 {
    public String decodeString(String s) {

        Deque<String> stack = new ArrayDeque<>();

        boolean isLeft = false;
        StringBuilder numberStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                String str = "";
                int size = 0;
                while (true) {
                    String pop = stack.pop();
                    if ("[".equals(pop)) {
                        isLeft = true;
                        continue;
                    }
                    if (isLeft) {
                        size = Integer.parseInt(pop);
                        isLeft = false;
                        break;
                    }
                    str = pop + str;
                }
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < size; j++) {
                    temp.append(str);
                }
                stack.push(temp.toString());
            } else {
                if (ch >= '0' && ch <= '9') {
                    numberStr.append(String.valueOf(ch));
                    continue;
                }
                if (numberStr.length() > 0) {
                    stack.push(numberStr.toString());
                    numberStr = new StringBuilder();
                }
                stack.push(String.valueOf(ch));
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }

    public static void main(String[] args) {
        App394 app394 = new App394();

        app394.decodeString("100[leetcode]");
    }
}
