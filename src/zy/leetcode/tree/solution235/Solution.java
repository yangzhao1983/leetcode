package zy.leetcode.tree.solution235;

import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(root, p);
        List<TreeNode> pathQ = getPath(root, q);
        TreeNode parent = null;
        int iP = 0;
        int iQ = 0;
        while(iP < pathP.size() && iQ <pathQ.size()){
            if(pathP.get(iP) == pathQ.get(iQ)){
                parent = pathP.get(iP);
                iP++;
                iQ++;
            }else{
                break;
            }
        }
        return parent;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target){
        List<TreeNode> path = new ArrayList<>();
        TreeNode cur = root;
        while(cur.val != target.val){
            path.add(cur);
            if(cur.val > target.val) cur = cur.left;
            else cur = cur.right;
        }
        path.add(target);
        return path;
    }
}
