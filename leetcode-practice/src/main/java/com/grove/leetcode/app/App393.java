package com.grove.leetcode.app;

public class App393 {

    public boolean validUtf8(int[] data) {
        int numOfNextBit = 0;

        int singleBitFirst = 1 << 7;
        int singleBitSec = 1 << 6;

        for (int i = 0; i < data.length; i++) {
            int num = data[i];
            if (numOfNextBit == 0) {
                int mark = 1 << 7;
                while ((num & mark) != 0) {
                    numOfNextBit += 1;
                    mark = mark >> 1;
                }

                // 单个字节，直接跳过下一个
                if (numOfNextBit == 0) {
                    continue;
                }

                // 只有2-4个字节场景才会有后面附属节点
                if (numOfNextBit > 4 || numOfNextBit == 1) {
                    return false;
                }
            } else {
                // 此处为不是有效字节的第一个字节，必须已10开头，否则就是非法
                if (!((num & singleBitFirst) != 0 && (num & singleBitSec) == 0)) {
                    return false;
                }
            }
            numOfNextBit--;
        }


        return numOfNextBit == 0;
    }

    public static void main(String[] args) {
        App393 app393 = new App393();

        app393.validUtf8(new int[]{235, 140,4});
    }

}
