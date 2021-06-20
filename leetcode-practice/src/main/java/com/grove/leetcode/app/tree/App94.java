package com.grove.leetcode.app.tree;

import com.grove.leetcode.model.TreeNode;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 */
public class App94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        //inorderTraversal(root, result);
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode poll = stack.poll();
            result.add(poll.val);
            root = poll.right;
        }

        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
