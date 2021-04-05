package com.grove.leetcode.app;

public class App1318 {

    public int minFlips(int a, int b, int c) {

        int sum = 0;

        while (a != 0 || b!=0 || c !=0) {
            int av = a & 1;
            int bv = b & 1;
            int cv = c & 1;

            if ((av | bv) != cv) {
                if (cv == 1) {
                    sum++;
                } else {
                    if (av == 1) {
                        sum++;
                    }
                    if (bv == 1) {
                        sum++;
                    }
                }
            }

            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        App1318 app1318 = new App1318();

        int i = app1318.minFlips(2, 6, 5);

        System.out.println(i);
    }
}
