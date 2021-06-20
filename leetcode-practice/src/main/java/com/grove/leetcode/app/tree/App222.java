package com.grove.leetcode.app.tree;

import com.grove.leetcode.model.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 */
public class App222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 计算左子树的高度
        int left = countLevel(root.left);
        // 计算右子树的高度
        int right = countLevel(root.right);

        // 判断两种情况
        if (left == right) {
            // 左子树高度等于右子树时，说明左子树为满完全二叉树，可以根据高度直接计算出节点数量
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level ++;
            root = root.left;
        }
        return level;
    }

}
