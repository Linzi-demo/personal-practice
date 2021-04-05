package com.grove.leetcode.app.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. 课程表
 */
public class App207 {

    boolean isValid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 构造每个科目的依赖关系
        List<List<Integer>> dependList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            dependList.add(new ArrayList<>());
        }
        for (int[] arr : prerequisites) {
            dependList.get(arr[0]).add(arr[1]);
        }

        // 记录节点的状态
        int[] visited = new int[numCourses];
        // 已每一个科目为起点，深度遍历依赖节点
        for (int i = 0; i < numCourses && isValid; i++) {
            dfs(i, dependList, visited);
        }

        return isValid;
    }

    private void dfs(int num, List<List<Integer>> dependList, int[] visited) {
        // 深度优先结束条件：存在回环
        if (visited[num] == 1) {
            isValid = false;
            return;
        }
        // 标记当前节点状态为搜索中
        visited[num] = 1;
        for (Integer i : dependList.get(num)) {
            if (!isValid) {
                return;
            }
            // 此处是个优化技巧，对于已经是搜索完成的节点，说明该节点及后续依赖节点不存在回环，不需要在进行搜索处理
            if (visited[i] != 2) {
                dfs(i, dependList, visited);
            }
        }
        // 正常结束，标记该节点状态为搜索完成
        visited[num] = 2;
    }

    public static void main(String[] args) {

        int[][] prerequisites = new int[2][2];
        prerequisites[0] = new int[]{1, 0};
        prerequisites[1] = new int[]{0, 1};

        App207 app207 = new App207();
        app207.canFinish(2, prerequisites);
    }

}
