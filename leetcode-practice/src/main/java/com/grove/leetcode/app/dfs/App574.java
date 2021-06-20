package com.grove.leetcode.app.dfs;

/**
 * 547. 省份数量
 */
public class App574 {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        boolean[] isVisited = new boolean[isConnected.length];

        int result = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!isVisited[i]) {
                result ++;
                dfs(isConnected, isVisited, i);
            }
        }
        return result;
    }

    private void dfs(int[][] isConnected, boolean[] isVisited, int i) {
        isVisited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !isVisited[j]) {
                dfs(isConnected, isVisited, j);
            }
        }
    }
}
