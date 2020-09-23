package zy.leetcode.tree.solution617;

import zy.leetcode.tree.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return doMerge(t1, t2);
    }

    private TreeNode doMerge(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode tn = null;
        if (t1 != null && t2 != null) {
            tn = new TreeNode(t1.val + t2.val);
            tn.left = doMerge(t1.left, t2.left);
            tn.right = doMerge(t1.right, t2.right);
        } else if (t1 == null) {
            tn = new TreeNode(t2.val);
            tn.left = doMerge(null, t2.left);
            tn.right = doMerge(null, t2.right);
        } else if (t2 == null) {
            tn = new TreeNode(t1.val);
            tn.left = doMerge(null, t1.left);
            tn.right = doMerge(null, t1.right);
        }
        return tn;
    }
}
