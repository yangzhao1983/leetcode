package zy.leetcode.btree.solution230;
import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int order = 0;
    private int kSmallest = -1;

    public int kthSmallest(TreeNode root, int k) {
        traverseInOrder(root, k);
        return kSmallest;
    }

    private void traverseInOrder(TreeNode root, int k){
        if(root == null){
            return;
        }

        traverseInOrder(root.left, k);
        ++ this.order;
        if(this.order == k){
            this.kSmallest = root.val;
            return;
        }else if(order >k){
            return;
        }

        traverseInOrder(root.right, k);
    }

    private static void test1(){
        Solution solution = new Solution();
        TreeNode tn1 = new TreeNode(3);
        TreeNode tn11 = new TreeNode(1);
        TreeNode tn12 = new TreeNode(4);
        TreeNode tn112 = new TreeNode(2);
        tn1.left = tn11;
        tn1.right = tn12;
        tn11.right = tn112;
        System.out.println(solution.kthSmallest(tn1, 3));
    }
    public static void main(String...strings){
        test1();
    }
}
