package com.grove.leetcode.app;

import com.grove.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 */
public class App114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        bfs(root, list);

        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void bfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        bfs(root.left, list);
        bfs(root.right, list);
    }



}
