package zy.leetcode.tree.solution226;

import zy.leetcode.tree.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        return doInvert(root);
    }

    private TreeNode doInvert(TreeNode root){
        if(root == null) return null;
        TreeNode newRight = doInvert(root.left);
        TreeNode newLeft = doInvert(root.right);
        root.left = newLeft;
        root.right = newRight;
        return root;
    }
}
