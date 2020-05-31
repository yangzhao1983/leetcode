package zy.leetcode.tree.solution94;

import org.junit.Assert;
import org.junit.Test;
import zy.leetcode.tree.TreeNode;

import java.util.*;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            if(visited.contains(top)){
                ans.add(top.val);
            }else{
                if(top.right != null){
                    stack.push(top.right);
                }
                stack.push(top);
                visited.add(top);
                if(top.left != null){
                    stack.push(top.left);
                }
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n12 = new TreeNode(2);
        TreeNode n121 = new TreeNode(3);

        n1.right = n12;
        n12.left = n121;

        Solution sol = new Solution();
        List<Integer> ans = sol.inorderTraversal(n1);
        System.out.println(ans);
    }
}
