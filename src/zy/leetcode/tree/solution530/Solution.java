package zy.leetcode.tree.solution530;

import zy.leetcode.tree.TreeNode;

public class Solution {
    private int diff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        doDFS(root, Integer.MAX_VALUE);
        return diff;
    }

    private int doDFS(TreeNode root, int last){
        if(root==null) return last;
        int leftLast  = doDFS(root.left, last);
        int cur = root.val;
        int newDiff = Math.abs(cur - leftLast);
        if( newDiff< diff) diff = newDiff;
        int rightLast = doDFS(root.right,cur);
        return rightLast;
    }
}
