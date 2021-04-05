package com.grove.leetcode.app.bfs;

import java.util.*;

/**
 * 279. 完全平方数
 */
public class App279 {

    public int numSquares(int n) {

        // 构造可选择的列表，平方数小于等于目标值都可以选择
        List<Integer> canChoice = new ArrayList<>();
        for (int i = 1; i*i <= n; i++) {
            canChoice.add(i*i);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        return bfs(queue, n, canChoice);
    }

    private int bfs(Queue<Integer> queue, int n, List<Integer> canChoice) {
        int result = 0;

        // 用于保存已经计算过得值，剪枝提升效率
        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (Integer temp : canChoice) {
                    temp += poll;
                    if (temp == n) {
                        return result+1;
                    }
                    // 剪枝
                    if (!set.contains(temp) && temp < n) {
                        queue.add(temp);
                        set.add(temp);
                    }
                }
            }
            result++;
        }
        return result;
    }
}
