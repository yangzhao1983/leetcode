package zy.leetcode.tree.solution222;

import zy.leetcode.tree.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        return doDFS(root);
    }

    private int doDFS(TreeNode root){
        if(root == null) return 0;
        int lCnt = doDFS(root.left);
        int rCnt = doDFS(root.right);
        return lCnt + rCnt + 1;
    }
}
