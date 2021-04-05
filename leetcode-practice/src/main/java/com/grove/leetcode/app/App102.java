package com.grove.leetcode.app;

import com.grove.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 */
public class App102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        bfs(queue, result);

        return result;
    }

    private void bfs(Queue<TreeNode> queue, List<List<Integer>> result) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.poll();
                temp.add(peek.val);
                if (peek.left != null) {
                    queue.add(peek.left);
                }

                if (peek.right != null) {
                    queue.add(peek.right);
                }
            }
            result.add(temp);
        }
    }
}
