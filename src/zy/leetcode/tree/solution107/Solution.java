package zy.leetcode.tree.solution107;

import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        LinkedList<TreeNode> q = new LinkedList<>();

        q.addFirst(root);

        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> tmp = new ArrayList<>();
            while(len-- > 0){
                TreeNode node = q.pollLast();
                if(node.left!=null) q.addFirst(node.left);
                if(node.right!=null) q.addFirst(node.right);
                tmp.add(node.val);
            }
            ans.add(0, tmp);
        }
        return ans;
    }
}
