package zy.leetcode.tree.solution104;

import zy.leetcode.tree.TreeNode;

public class Solution {
    private int ans = 0;
    public int maxDepth(TreeNode root) {
        doDFS(root, 0);
        return ans;
    }

    private void doDFS(TreeNode root, int depth){
        if(root == null){
            if(depth > ans) ans = depth;
            return;
        }

        doDFS(root.left, depth+1);
        doDFS(root.right, depth+1);
    }
}
