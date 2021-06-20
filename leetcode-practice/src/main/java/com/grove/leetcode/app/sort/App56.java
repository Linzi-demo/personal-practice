package com.grove.leetcode.app.sort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * 56. 合并区间
 */
public class App56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Deque<int[]> statck = new ArrayDeque<>();
        for (int[] arr : intervals) {
            if (statck.isEmpty() || arr[0] > statck.peek()[1]) {
                statck.push(arr);
                continue;
            }
            int[] pop = statck.pop();
            pop[1] = Math.max(pop[1],arr[1]);
            statck.push(pop);
        }
        int[][] result = new int[statck.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = statck.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        App56 app56 = new App56();
        app56.merge(new int[][]{new int[]{1,3}, new int[]{2,6},new int[]{8,10}, new int[]{15,18}});
    }
}
