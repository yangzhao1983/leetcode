package zy.leetcode.bst.solution99;

import apple.laf.JRSUIUtils;
import org.junit.Test;
import zy.leetcode.tree.TreeNode;

public class Solution {

    boolean start = false;
    int last = 0;

    TreeNode lastNode = null;
    TreeNode firstNode = null;
    TreeNode secondNode = null;

    /**
     * 1. find the first node, node1.val > 'next' node.
     * 2. find the second node, node1.val < 'last' node.
     * <p>
     * swap there val.
     * <p>
     * 'next' and 'last': dfs.
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        doDFS(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    private void doDFS(TreeNode root) {

        if (root.left != null) {
            doDFS(root.left);
        }

        int cur = root.val;
        if (!start) {
            start = true;
        } else {
            if (cur < last) {
                if (firstNode == null) {
                    firstNode = lastNode;
                }
                secondNode = root;
            }
        }
        last = cur;
        lastNode = root;

        if (root.right != null) {
            doDFS(root.right);
        }
    }

    @Test
    public void test1() {
        TreeNode n1 = new TreeNode(3);
        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(4);
        TreeNode n121 = new TreeNode(2);

        n1.left = n11;
        n1.right = n12;
        n12.left = n121;

        Solution sol = new Solution();
        sol.recoverTree(n1);
        System.out.println();
    }
}
