package zy.leetcode.btree.solution450;

import zy.leetcode.tree.TreeNode;

public class Solution {
    /**
     * pathFromRootToNode:
     * f0 (target node), f1, f2... root, dummyHead
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        if (key < root.val){
            root.left = deleteNode(root.left, key);
            return root;
        }

        if(key > root.val){
            root.right = deleteNode(root.right, key);
            return  root;
        }

        // root should be deleted
        if (root.left == null){
            TreeNode tmpTreeNode = root.right;
            root.right = null;
            return tmpTreeNode;
        }

        if (root.right == null){
            TreeNode tmpTreeNode = root.left;
            root.left = null;
            return tmpTreeNode;
        }

        TreeNode minimumNode = getMinimumNode(root.right);
        TreeNode copyTreeNode = new TreeNode(minimumNode.val);

        copyTreeNode.left = root.left;
        copyTreeNode.right = removeMinimumNode(root.right);

        root.left = null;
        root.right = null;
        return copyTreeNode;
    }

    private static TreeNode removeMinimumNode(TreeNode root){
        if(root.left == null){
            TreeNode tmpTreeNode = root.right;
            root.right = null;
            return tmpTreeNode;
        }

        root.left = removeMinimumNode(root.left);
        return root;
    }

    /**
     * find the minimum of the tree, or the "leftest" node of the tree
     *
     * @return
     */
    private static TreeNode getMinimumNode(TreeNode root){
        if(root.left == null){
            return root;
        }else{
            return getMinimumNode(root.left);
        }
    }
}
