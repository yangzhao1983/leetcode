package zy.leetcode.tree.solution404;

import zy.leetcode.tree.TreeNode;

public class Solution {
    private int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null || ( root.left == null && root.right==null)) return 0;
        doDFS(root, true);
        return ans;
    }

    private void doDFS(TreeNode root, boolean isLeft) {
        if (root.left != null)
            doDFS(root.left, true);

        if (root.right != null)
            doDFS(root.right, false);

        if (isLeft && root.left == null && root.right==null) ans += root.val;
    }
}
