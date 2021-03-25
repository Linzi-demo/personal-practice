package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

/**
 * 60. 排列序列
 */
@Component
public class App60 {


    public String getPermutation(int n, int k) {

        // 获取1-n的所有对应数的乘阶
        int[] allNums = getAllNums(n);

        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[n+1];
        dfs(n, 0, k, used, path, allNums);

        return path.toString();
    }

    private void dfs(int n, int sum, int k, boolean[] used, StringBuilder path, int[] allNums) {
        if (sum == n) {
            return;
        }

        int cnt = allNums[n-1-sum];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }

            path.append(i);
            used[i] = true;
            dfs(n, sum+1, k, used, path, allNums);

            return;
        }
    }

    private int[] getAllNums(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            result[i] = result[i-1]*i;

        }
        return result;
    }
}
