package zy.leetcode.tree.solution113;

import apple.laf.JRSUIUtils;
import org.junit.Test;
import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private int targetSum;
    private List<Integer> single = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.targetSum = sum;
        doDFS(root, 0);
        return ans;
    }

    private void doDFS(TreeNode root, int pSum){
        if(root == null){
            return;
        }
        int cSum = pSum + root.val;
        single.add(root.val);

        if(root.left == null && root.right == null){
            if(cSum == targetSum){
                List<Integer> rel = new ArrayList<>();
                rel.addAll(single);
                ans.add(rel);
            }
        }

        doDFS(root.left, cSum);
        doDFS(root.right, cSum);

        single.remove(single.size()-1);
    }

    @Test
    public void test1(){
        TreeNode t1 = new TreeNode(-2);
        TreeNode t12 = new TreeNode(-3);
        t1.right = t12;
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.pathSum(t1, -5);
        System.out.println();
    }
}
