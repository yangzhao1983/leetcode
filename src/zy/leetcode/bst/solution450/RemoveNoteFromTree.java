package zy.leetcode.bst.solution450;

import zy.leetcode.tree.TreeNode;

/**
 * Created by kaiser_zhao on 2019/9/12.
 */
public class RemoveNoteFromTree {

    public static void main(String...strings){
        testcase1();
    }

    private static void testcase1(){
        TreeNode rn1 = new TreeNode(5);
        TreeNode rn11 = new TreeNode(3);
        TreeNode rn12 = new TreeNode(6);
        TreeNode rn111 = new TreeNode(2);
        TreeNode rn112 = new TreeNode(4);
        TreeNode rn122 = new TreeNode(7);

        rn1.left = rn11;
        rn1.right = rn12;
        rn1.left.left = rn111;
        rn1.left.right = rn112;
        rn12.right = rn122;

        TreeNode.output(deleteNode(rn1, 3), "===");

    }

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
