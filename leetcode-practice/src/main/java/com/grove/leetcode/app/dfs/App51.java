package com.grove.leetcode.app.dfs;

import java.util.*;

/**
 * 51. N 皇后
 */
public class App51 {

    char[][] isQ;
    Set<Integer> xSet = new HashSet<>();
    Set<Integer> ySet = new HashSet<>();
    Set<Integer> xySet = new HashSet<>();
    Set<Integer> yxSet = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        isQ = new char[n][n];
        for (char[] arr : isQ) {
            Arrays.fill(arr, '.');
        }

        dfs(result, 0, n);

        return result;
    }

    private void dfs(List<List<String>> result, int x, int n) {
        if (x == n) {
            result.add(getQList());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!haveQ(x, i)) {
                addQ(x, i);
                dfs(result, x + 1, n);
                removeQ(x, i);
            }
        }
    }

    private void addQ(int x, int y) {
        isQ[x][y] = 'Q';
        xSet.add(x);
        ySet.add(y);
        xySet.add(x+y);
        yxSet.add(x-y);
    }

    private void removeQ(int x, int y) {
        isQ[x][y] = '.';
        xSet.remove(x);
        ySet.remove(y);
        xySet.remove(x+y);
        yxSet.remove(x-y);
    }

    private boolean haveQ(int x, int y) {
        return xSet.contains(x) || ySet.contains(y) || xySet.contains(x+y) || yxSet.contains(x-y);
    }

    private List<String> getQList() {
        List<String> list = new ArrayList<>();
        for (char[] arr : isQ) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : arr) {
                stringBuilder.append(ch);
            }
            list.add(stringBuilder.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        App51 app51 = new App51();
        app51.solveNQueens(4);
    }

}
