package zy.leetcode.tree.solution110again;

import zy.leetcode.tree.TreeNode;

public class Solution {

    private boolean found = false;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        calDepth(root);
        return !found;
    }

    private int calDepth(TreeNode root){
        if(found) return -1;

        // cal left
        int l = root.left == null? 0 : calDepth(root.left);
        if(l==-1) return -1;

        // cal right
        int r = root.right == null ? 0:calDepth(root.right);
        if(r==-1) return -1;

        // if |left - right| > 1,
        if(Math.abs(r-l)>1){
            found = true;
            return -1;
        }else{
            return Math.max(r, l) + 1;
        }
    }
}
