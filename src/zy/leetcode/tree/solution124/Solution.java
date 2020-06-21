package zy.leetcode.tree.solution124;

import zy.leetcode.tree.TreeNode;

public class Solution {

    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return ans;
        int m = root.val;
        int l = findMaxSumChildTree(root.left);
        int r = findMaxSumChildTree(root.right);
        int sum = m + l + r;
        if(sum > ans) ans = sum;
        return ans;
    }

    private int findMaxSumChildTree(TreeNode root){
        if(root == null) return 0;

        int m = root.val;

        int l = findMaxSumChildTree(root.left);

        int r = findMaxSumChildTree(root.right);

        int sum = m + r + l;

        if(sum > ans) ans = sum;

        int maxChild =  Math.max(l, r) + m;
        return maxChild > 0 ? maxChild : 0;
    }
}
