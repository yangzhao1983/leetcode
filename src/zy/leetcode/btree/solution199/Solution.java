package zy.leetcode.btree.solution199;

import org.junit.Assert;
import org.junit.Test;
import sun.awt.geom.AreaOp;
import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Integer> ans = new ArrayList<>();
    private int depth = 0;
    /**
     * depth = 0
     * dfs, if curDepth  > depth, add it to and, depth++
     *
     * dfs (curNode, curLen):
     * 1. if curNode == null, return,
     *    else if curLen > depth, add it to ans, depth++
     * dfs right
     * dfs left
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    private void dfs(TreeNode curNode, int curDepth){
        if(curNode == null){
            return;
        }else if(curDepth > depth){
            ans.add(curNode.val);
            depth++;
        }

        dfs(curNode.right, curDepth+1);
        dfs(curNode.left, curDepth+1);
    }

    @Test
    public void test1(){
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn11 = new TreeNode(2);
        TreeNode tn12 = new TreeNode(3);

        tn1.left = tn11;
        tn1.right = tn12;

        TreeNode tn112 = new TreeNode(5);
        tn11.right = tn112;

        TreeNode tn122 = new TreeNode(4);
        tn12.right = tn122;

        Solution sol = new Solution();
        List<Integer> list = sol.rightSideView(tn1);
        System.out.println();
    }
}
