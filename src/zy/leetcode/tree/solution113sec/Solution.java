package zy.leetcode.tree.solution113sec;

import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans =  new ArrayList<>();
    private int sum;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        doDFS(root, new ArrayList<>(), 0);
        return ans;
    }

    private void doDFS(TreeNode root, List<Integer> path, int curSum){
        if(root==null) return;

        path.add(root.val);
        curSum += root.val;
        if(root.left == null && root.right == null && sum == curSum){
            List<Integer> single = new ArrayList<>();
            single.addAll(path);
            ans.add(single);
        }else{
            doDFS(root.left, path, curSum);
            doDFS(root.right, path, curSum);
        }
        path.remove(path.size()-1);
    }
}
