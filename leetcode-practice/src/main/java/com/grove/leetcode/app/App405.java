package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法
 */
@Component
public class App405 {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] chars = "0123456789abcdef".toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            int index = num & 15;
            stringBuilder.append(chars[index]);
            num >>>=4;
        }

        return stringBuilder.reverse().toString();
    }

}
