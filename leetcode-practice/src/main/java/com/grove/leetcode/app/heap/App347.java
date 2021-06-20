package com.grove.leetcode.app.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 */
public class App347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() == k) {
                if (queue.peek()[1] < entry.getValue()) {
                    queue.poll();
                    queue.add(new int[] {entry.getKey(), entry.getValue()});
                }
            } else {
                queue.add(new int[] {entry.getKey(), entry.getValue()});
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i ++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        App347 app347 = new App347();
        app347.topKFrequent(new int[]{1,2,2,3,3,3,4,4,4,4}, 3);
    }
}
