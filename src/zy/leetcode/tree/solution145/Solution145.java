package zy.leetcode.tree.solution145;

import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution145 {
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        doPostOrder(root);
        return ans;
    }

    private void doPostOrder(TreeNode root){
        if(root==null) return;
        doPostOrder(root.left);
        doPostOrder(root.right);
        ans.add(root.val);
    }
}
