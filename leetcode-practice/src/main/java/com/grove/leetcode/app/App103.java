package com.grove.leetcode.app;

import com.grove.leetcode.model.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 */
public class App103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        boolean isLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                temp.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            if (!isLeft) {
                List<Integer> reverse = new ArrayList<>();
                for (int i = temp.size()-1; i>=0; i--) {
                    reverse.add(temp.get(i));
                }
                result.add(reverse);
            } else {
                result.add(temp);
            }
            isLeft = !isLeft;
        }
    }
}
