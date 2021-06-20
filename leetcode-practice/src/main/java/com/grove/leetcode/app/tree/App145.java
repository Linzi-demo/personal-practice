package com.grove.leetcode.app.tree;

import com.grove.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 */
public class App145 {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        //lastScan(root, result);
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root !=null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode poll = stack.poll();
            if (poll.right != null && poll.right != pre) {
                stack.push(poll);
                root = poll.right;
            } else {
                result.add(poll.val);
                pre = poll;
            }
        }

        return result;
    }

    private void lastScan(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // 遍历左子树
        lastScan(root.left, result);
        // 遍历右子树
        lastScan(root.right, result);
        // 遍历根节点
        result.add(root.val);
    }
}
