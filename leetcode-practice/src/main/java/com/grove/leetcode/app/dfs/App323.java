package com.grove.leetcode.app.dfs;

/**
 * 323. 无向图中连通分量的数目
 */
public class App323 {
    public int countComponents(int n, int[][] edges) {
        if (n == 0) {
            return 0;
        }
        int[] isVisited = new int[n];

        int result = 0;
        for (int i = 0; i < edges.length; i++) {
            if (isVisited[edges[i][0]] + isVisited[edges[i][1]] == 0) {
                result++;
                dfs(edges, i, isVisited);
            }
        }
        // 没有被连接的节点不在数据中记录，需要单独处理
        for (int i = 0; i < n; i ++) {
            if (isVisited[i] == 0) {
                result++;
            }
        }
        return result;
    }

    private void dfs(int[][] edges, int start, int[] isVisited) {
        isVisited[edges[start][0]] = 1;
        isVisited[edges[start][1]] = 1;

        for (int i = 0; i < edges.length; i++) {
            if (isVisited[edges[i][0]] + isVisited[edges[i][1]] == 1) {
                dfs(edges, i, isVisited);
            }
        }
    }
}
