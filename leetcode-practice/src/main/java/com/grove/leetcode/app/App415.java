package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

/**
 * 415. 字符串相加
 */
@Component
public class App415 {

    public String addStrings(String num1, String num2) {
        int temp = 0;
        StringBuilder result = new StringBuilder();

        for (int i = num1.length()-1, j = num2.length()-1 ; i >= 0 || j >= 0; i--,j--) {
            int n1 = i >= 0 ? Integer.parseInt(String.valueOf(num1.charAt(i))) : 0;
            int n2 = j >= 0 ? Integer.parseInt(String.valueOf(num2.charAt(j))) : 0;

            int count = n1 + n2 + temp;
            result.append(count%10);

            temp = count/10;
        }
        if (temp != 0) {
            result.append(temp);
        }

        return result.reverse().toString();
    }

}
