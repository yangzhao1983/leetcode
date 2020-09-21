package zy.leetcode.tree.solution538;

import zy.leetcode.tree.TreeNode;

import java.util.Stack;

public class Solution {
    private Stack<TreeNode> stack = new Stack<>();

    public TreeNode convertBST(TreeNode root) {
        doDFS(root);
        int sum = 0;

        if(!stack.isEmpty()) sum = stack.pop().val;

        while(!stack.isEmpty()){
            sum += stack.peek().val;
            stack.pop().val =sum;
        }

        return root;
    }

    /**
     * Tree: left < root < right
     *
     * stack:
     * from smaller to greater
     * level 1->n
     * left_n1, root_n-1_1, right_n1, root_n2, left_n2, right_n2...
     */
    private void doDFS(TreeNode root){
        if(root==null) return;
        if(root.left!=null) doDFS(root.left);
        stack.add(root);
        if(root.right!=null) doDFS(root.right);
    }
}
