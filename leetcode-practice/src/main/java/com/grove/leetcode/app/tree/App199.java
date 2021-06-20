package com.grove.leetcode.app.tree;

import com.grove.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 */
public class App199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 广度优先变形，只记录每层最右边的元素
            TreeNode right = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                right = poll;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            result.add(right.val);
        }
        return result;
    }

}
