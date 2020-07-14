package zy.leetcode.stack.solution144;

import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tn = stack.pop();
            ans.add(tn.val);
            if(tn.right != null) stack.push(tn.right);
            if(tn.left != null) stack.push(tn.left);
        }
        return ans;
    }
}
