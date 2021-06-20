package com.grove.leetcode.app.dfs;

import com.grove.leetcode.model.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 */
public class App129 {
    int result = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        StringBuilder str = new StringBuilder();

        dfs(root, str);
        return result;
    }

    private void dfs(TreeNode root, StringBuilder str) {
        str.append(root.val);

        if (root.left == null && root.right == null) {
            result += Integer.parseInt(str.toString());
            return;
        }

        if (root.left != null) {
            dfs(root.left, str);
            str.deleteCharAt(str.length() - 1);
        }
        if (root.right != null) {
            dfs(root.right, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
