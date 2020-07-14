package zy.leetcode.tree.solution144;

import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        doDFS(root);
        return ans;
    }

    private void doDFS(TreeNode root){
        if(root == null) return;
        ans.add(root.val);
        doDFS(root.left);
        doDFS(root.right);
    }
}
