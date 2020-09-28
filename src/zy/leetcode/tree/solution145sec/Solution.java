package zy.leetcode.tree.solution145sec;

import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        doDFS(root);
        return ans;
    }

    private void doDFS(TreeNode root){
        if(root == null) return;
        doDFS(root.left);
        doDFS(root.right);
        ans.add(root.val);
    }
}
