package zy.leetcode.tree.solution107again;

import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        int cntCur = 0;
        int cntNext = 0;

        List<Integer> level = new ArrayList<>();

        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        cntCur = 1;
        while(!q.isEmpty()){
            TreeNode node = q.pollFirst();
            level.add(node.val);
            cntCur--;

            if(node.left != null){
                q.addLast(node.left);
                cntNext ++;
            }
            if(node.right != null){
                q.add(node.right);
                cntNext++;
            }

            if(cntCur==0){
                cntCur = cntNext;
                cntNext = 0;
                ans.add(0,level);

                level = new ArrayList<>();
            }
        }
        if(level.size() > 0) ans.add(0, level);
        return ans;
    }
}
