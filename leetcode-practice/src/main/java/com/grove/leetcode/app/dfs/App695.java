package com.grove.leetcode.app.dfs;

public class App695 {

    int maxSize = 0;
    int currentSize = 0;
    int n = 0;
    int m = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return maxSize;
        }

        n = grid.length;
        m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    maxSize = Math.max(maxSize, currentSize);
                    currentSize = 0;
                }
            }
        }
        return maxSize;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        currentSize++;

        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
}
