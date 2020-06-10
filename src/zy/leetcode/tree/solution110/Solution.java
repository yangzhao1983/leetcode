package zy.leetcode.tree.solution110;

import zy.leetcode.tree.TreeNode;

public class Solution {

    private boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        calDepth(root);
        return ans;
    }

    private int calDepth(TreeNode root){
        if(!ans) return 0;

        if(root == null) return 0;

        int l = calDepth(root.left);
        int r = calDepth(root.right);

        if(Math.abs(l -r )>1){
            ans = false;
            return 0;
        }

        return Math.max(l, r) + 1;
    }
}
