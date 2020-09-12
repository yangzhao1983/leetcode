package zy.leetcode.tree.solution637;

import org.junit.Test;
import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        // for each level, calculate the cnt of node in next level
        LinkedList<TreeNode> q = new LinkedList<>();
        List<Double> ans = new ArrayList<>();

        q.addLast(root);

        double sum = 0;
        int levelCnt = 1;
        int cnt = 1;
        int levelCntNext = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            if (node.left != null) {
                q.addLast(node.left);
                levelCntNext++;
            }
            if (node.right != null) {
                q.addLast(node.right);
                levelCntNext++;
            }
            sum += node.val;
            levelCnt--;
            if (levelCnt == 0) {
                // do calculation
                ans.add(sum / cnt);
                levelCnt = levelCntNext;
                cnt = levelCnt;
                levelCntNext = 0;
                sum = 0;
            }
        }
        return ans;
    }

    @Test
    public void test1() {
        TreeNode tn1 = new TreeNode(3);
        TreeNode tn11 = new TreeNode(9);
        TreeNode tn12 = new TreeNode(20);
        TreeNode tn121 = new TreeNode(15);
        tn1.left = tn11;
        tn1.right = tn12;
        tn12.left = tn121;
        Solution sol = new Solution();
        List<Double> ans = sol.averageOfLevels(tn1);
        System.out.println();
    }
}
