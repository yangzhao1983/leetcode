package zy.leetcode.bst.solution938;

import zy.leetcode.tree.TreeNode;

/**
 * Created by kaiser_zhao on 2019/9/13.
 */
public class LDR {

    public static void main(String...strings){
        testcase1();
    }

    private static void testcase1(){
        TreeNode rn1 = new TreeNode(10);
        TreeNode rn11 = new TreeNode(5);
        TreeNode rn12 = new TreeNode(15);
        TreeNode rn111 = new TreeNode(3);
        TreeNode rn112 = new TreeNode(7);
        TreeNode rn122 = new TreeNode(18);

        rn1.left = rn11;
        rn1.right = rn12;
        rn1.left.left = rn111;
        rn1.left.right = rn112;
        rn1.right.right = rn122;

        System.out.println(rangeSumBST(rn1, 7,15));

    }

    private static int sum = 0;

    public static int rangeSumBST(TreeNode root, int L, int R) {
        ldr(root, L, R);
        return sum;
    }

    private static void ldr(TreeNode root, int L, int R){
        if(root == null){
            return;
        }

        ldr(root.left, L, R);
        if(root.val >= L && root.val <=R){
            sum += root.val;
        }

        if(root.val > R){
            return;
        }

        ldr(root.right, L, R);
    }
}
