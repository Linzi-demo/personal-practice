package com.grove.leetcode.app;

import com.grove.leetcode.model.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 107. 二叉树的层序遍历 II
 */
public class App107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);

                if (poll.left !=null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }
}
