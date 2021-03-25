package com.grove.leetcode.app;

public class App191 {

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n-1);
        }
        return sum;
    }

}
