package com.grove.leetcode.app.dfs;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

/**
 * 1631. 最小体力消耗路径
 */
public class App1631 {
    int min = Integer.MAX_VALUE;
    Deque<Integer> stack = new ArrayDeque<>();
    int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int minimumEffortPath(int[][] heights) {
        if (heights == null) {
            return 0;
        }

        boolean[][] isVisited = new boolean[heights.length][heights[0].length];

        dfs(heights, isVisited, heights[0][0], 0, 0);
        return min;
    }

    private void dfs(int[][] heights, boolean[][] isVisited, int pre, int i, int j) {

        isVisited[i][j] = true;
        int temp = Math.abs(heights[i][j] - pre);
        stack.push(temp);

        if (temp > min) {
            return;
        }

        if (i == heights.length-1 && j == heights[0].length-1) {
            min = Math.min(min, stack.stream().max(Comparator.comparingInt(a -> a)).get());
        }

        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (isArea(newX, newY, heights) && !isVisited[newX][newY]) {
                dfs(heights, isVisited, heights[i][j], newX, newY);
                stack.pop();
                isVisited[newX][newY] = false;
            }
        }
    }

    private boolean isArea(int newX, int newY, int[][] heights) {
        if (newX < 0 || newY < 0 || newX >= heights.length || newY >= heights[0].length) {
            return false;
        }
        return true;
    }
}
