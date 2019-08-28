package zy.leetcode.tree.solution230;

import zy.leetcode.tree.TreeNode;

/**
 * Created by kaiser_zhao on 2019/8/21.
 */
public class RecurseLR {

    public static void main(String...strings){
        TreeNode rn1 = new TreeNode(5);
        TreeNode rn2 = new TreeNode(3);
        TreeNode rn3 = new TreeNode(6);
        TreeNode rn4 = new TreeNode(2);
        TreeNode rn5 = new TreeNode(4);
        TreeNode rn6 = new TreeNode(1);

        rn1.left = rn2;
        rn1.right = rn3;
        rn2.left = rn4;
        rn2.right = rn5;
        rn4.left =rn6;

        System.out.println(kthSmallest(rn1, 3));
    }

    private static void testcase2(){
        TreeNode rn1 = new TreeNode(5);
        TreeNode rn2 = new TreeNode(3);
        TreeNode rn3 = new TreeNode(6);
        TreeNode rn4 = new TreeNode(2);
        TreeNode rn5 = new TreeNode(4);
        TreeNode rn6 = new TreeNode(1);

        rn1.left = rn2;
        rn1.right = rn2;
        rn2.left = rn3;
        rn2.right = rn4;
        rn3.left =rn6;

        System.out.println(kthSmallest(rn1, 3));
    }

    private static void testcase1(){
        TreeNode rn1 = new TreeNode(3);
        TreeNode rn2 = new TreeNode(1);
        TreeNode rn3 = new TreeNode(4);
        TreeNode rn4 = new TreeNode(2);

        rn1.left = rn2;
        rn2.right = rn4;
        rn1.right = rn3;

        System.out.println(kthSmallest(rn1, 1));
    }

    // global counter
    private static int counter = 0;

    // val
    private static int ans = -1;

    public static int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return ans;
    }

    private static void traverse(TreeNode node, int k){
        if(node == null){
            return;
        }

        traverse(node.left, k);
        if(counter == k){
            return;
        }else{
            counter ++;
            if(counter == k){
                ans = node.val;
            }
        }
        traverse(node.right, k);
    }
}
