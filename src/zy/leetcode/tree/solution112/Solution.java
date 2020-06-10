package zy.leetcode.tree.solution112;

import zy.leetcode.tree.TreeNode;

public class Solution {
    private int targetSum;
    public boolean hasPathSum(TreeNode root, int sum) {
        this.targetSum = sum;
        return checkSum(root,0);
    }

    private boolean checkSum(TreeNode root, int pSum){
        if(root == null){
            return false;
        }

        int cSum = pSum + root.val;

        if(root.left == null && root.right == null){
            return cSum == targetSum;
        }

        if(checkSum(root.left, cSum)){
            return true;
        }else{
            return checkSum(root.right, cSum);
        }
    }
}
