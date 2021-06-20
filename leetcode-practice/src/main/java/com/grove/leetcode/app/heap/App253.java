package com.grove.leetcode.app.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 253. 会议室 II
 */
public class App253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 按照开始时间升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();

        // 第一场会议
        endTimeQueue.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // 当前会议开始时间大于最早结束的会议室时间，那么就可以腾出会议室继续使用
            if (intervals[i][0] >= endTimeQueue.peek()) {
                endTimeQueue.poll();
            }
            // 不然就会开一间新的会议室
            endTimeQueue.add(intervals[i][1]);
        }
        return endTimeQueue.size();
    }
}
