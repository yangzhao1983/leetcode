package zy.leetcode.tree.solution98;

import org.junit.Test;
import zy.leetcode.tree.TreeNode;

public class Solution {
    /**
     * left < root
     * left.left < root
     * left.right < root
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return traverseTree(root, null, null);
    }

    private boolean traverseTree(TreeNode root, Integer top, Integer bottom){
        if(root == null){
            return true;
        }

        if (bottom != null && root.val <= bottom) return false;
        if (top != null && root.val >= top) return false;

        return traverseTree(root.left, root.val, bottom)
                ? traverseTree(root.right, top, root.val):false;
    }
}
