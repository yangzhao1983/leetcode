package zy.leetcode.tree.solution111;

import zy.leetcode.tree.TreeNode;

public class Solution {

    private int ans = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        calDepth(root,0);
        return ans;
    }

    private void calDepth(TreeNode root, int pd){
        int cd = pd + 1;

        if(root.left == null && root.right == null){

            if(cd < ans) ans = cd;
            return;
        }
        if(root.left != null){
            calDepth(root.left, cd);
        }
        if(root.right != null){
            calDepth(root.right, cd);
        }

    }
}
