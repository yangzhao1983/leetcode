package zy.leetcode.tree.solution437;

import org.junit.Assert;
import org.junit.Test;
import zy.leetcode.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private int ans = 0;
    private int sum = 0;
    private Set<TreeNode> visited = new HashSet<>();
    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        doDFS(root, 0);
        return ans;
    }

    private void doDFS(TreeNode root, int curSum){
        if(root == null) return;

        curSum += root.val;
        if(curSum == sum)
        {
            ans++;
        }
        doDFS(root.left, curSum);
        doDFS(root.right, curSum);

        if(root.left!=null){
            if(visited.contains(root.left)) return;
            else {
                visited.add(root.left);
                doDFS(root.left, 0);
            }
        }

        if(root.right!=null){
            if(visited.contains(root.right)) return;
            else {
                visited.add(root.right);
                doDFS(root.right, 0);
            }
        }
    }

    @Test
    public void test1(){
        TreeNode tn = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn22 = new TreeNode(3);
        TreeNode tn222 = new TreeNode(4);
        tn.right = tn2;
        tn2.right = tn22;
        tn22.right = tn222;
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.pathSum(tn, 3));
    }
}
