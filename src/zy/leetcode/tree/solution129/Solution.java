package zy.leetcode.tree.solution129;

import zy.leetcode.tree.TreeNode;

public class Solution {
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        else calSum(root, 0);
        return ans;
    }

    private void calSum(TreeNode root, int sum){
        sum = sum *10 + root.val;

        if(root.left==null && root.right==null){
            ans += sum;
            return;
        }

        if(root.left != null) calSum(root.left, sum);
        if(root.right!=null) calSum(root.right, sum);
    }
}
