package zy.leetcode.tree.solution102;

import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        doDFS(root, 1);
        return ans;
    }

    private void doDFS(TreeNode root, int dep){
        if(root == null){
            return;
        }

        if(ans.size() < dep){
            ans.add(new ArrayList<>());
        }
        ans.get(dep-1).add(root.val);

        doDFS(root.left, dep+1);
        doDFS(root.right, dep+1);
    }
}
