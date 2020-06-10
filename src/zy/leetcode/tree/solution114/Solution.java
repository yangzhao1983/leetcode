package zy.leetcode.tree.solution114;

import zy.leetcode.tree.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        doFlatten(root);
    }

    private TreeNode doFlatten(TreeNode root){
        if(root == null){
            return null;
        }

        if(root.left == null && root.right==null){
            return root;
        }

        TreeNode l = root.left;
        TreeNode r = root.right;

        TreeNode lTail = doFlatten(root.left);
        TreeNode rTail = doFlatten(root.right);

        if(lTail != null) {
            root.right = l;
            lTail.right = r;
            root.left = null;
        }

        if(rTail==null){
            return lTail;
        }else{
            return rTail;
        }
    }
}
