package com.grove.leetcode.app.dfs;

import com.grove.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 98. 验证二叉搜索树
 */
public class App98 {

    /**
     * 解法一：深度有限遍历，这里对应中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        double min = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null){
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode pop = stack.pop();

            // 由于是搜索树，所以中序遍历的节点值一定是递增的
            if (pop.val <= min) {
                return false;
            }
            min = pop.val;

            root = pop.right;
        }
        return true;
    }
}
