package zy.leetcode.bst.solution701;

import zy.leetcode.tree.TreeNode;

/**
 * Created by kaiser_zhao on 2019/9/13.
 */
public class BSTInsert {
    public static void main(String...strings){
        testcase1();
    }

    private static void testcase1(){
        TreeNode rn1 = new TreeNode(4);
        TreeNode rn11 = new TreeNode(2);
        TreeNode rn12 = new TreeNode(7);
        TreeNode rn111 = new TreeNode(1);
        TreeNode rn112 = new TreeNode(3);

        rn1.left = rn11;
        rn1.right = rn12;
        rn1.left.left = rn111;
        rn1.left.right = rn112;

        TreeNode.output(insertIntoBST(rn1, 5), "===");

    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        insertBST(root,val);
        return root;
    }

    private static void insertBST(TreeNode root, int val){
        if(root == null){
            return;
        }
        if(val < root.val){
            if(root.left != null){
                insertBST(root.left, val);
            }else{
                TreeNode newTreeNode = new TreeNode(val);
                root.left = newTreeNode;
                return;
            }
        }

        if(val > root.val){
            if(root.right != null){
                insertBST(root.right, val);
            }else{
                TreeNode newTreeNode = new TreeNode(val);
                root.right = newTreeNode;
                return;
            }
        }
    }
}
