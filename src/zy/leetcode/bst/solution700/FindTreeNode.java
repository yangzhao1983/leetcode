package zy.leetcode.bst.solution700;

import zy.leetcode.tree.TreeNode;

/**
 * Created by kaiser_zhao on 2019/9/13.
 */
public class FindTreeNode {

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

        TreeNode.output(searchBST(rn1, 3), "===");

    }

    public static TreeNode searchBST(TreeNode root, int val) {
        return bstSearch(root, val);
    }

    private static TreeNode bstSearch(TreeNode root, int val){
        if(root == null){
            return null;
        }

        if(val < root.val){
            return bstSearch(root.left, val);
        }

        if(val > root.val){
            return bstSearch(root.right, val);
        }

        return root;
    }
}
