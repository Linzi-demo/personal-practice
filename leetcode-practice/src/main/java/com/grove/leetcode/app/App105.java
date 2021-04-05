package com.grove.leetcode.app;

import com.grove.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class App105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int preLength = preorder.length;
        int inLength = inorder.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preLength - 1, map, 0, inLength - 1);
    }

    private TreeNode buildTree(int[] preorder, int preleft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preleft > preRight || inLeft > inRight) {
            return null;
        }

        int rootVal = preorder[preleft];
        TreeNode root = new TreeNode(rootVal);

        Integer pIndex = map.get(rootVal);

        root.left = buildTree(preorder, preleft + 1, pIndex - inLeft + preleft, map, inLeft, pIndex - 1);

        root.right = buildTree(preorder, pIndex - inLeft + preleft + 1, preRight, map, pIndex + 1, inRight);

        return root;
    }

    public static void main(String[] args) {
        App105 app105 = new App105();

        app105.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
    }

}
