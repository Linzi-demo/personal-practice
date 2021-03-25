package com.grove.leetcode.app;

import com.grove.leetcode.model.TreeNode;

/**
 * 226. 翻转二叉树
 */
public class App226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }
}
