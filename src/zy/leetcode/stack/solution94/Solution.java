package zy.leetcode.stack.solution94;

import org.junit.Test;
import zy.leetcode.tree.TreeNode;

import java.util.*;

public class Solution {
    private List<Integer> ans = new ArrayList<>();
    private Set<TreeNode> visited = new HashSet<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if (cur.right != null) {
                if (!visited.contains(cur.right)) {
                    stack.add(cur.right);
                    visited.add(cur.right);
                }
            }

            if (cur.left == null || visited.contains(cur.left)) {
                ans.add(cur.val);
                visited.add(cur);
            } else {
                stack.add(cur);
                stack.add(cur.left);
            }
        }
        return ans;
    }

    @Test
    public void test1() {
        Solution sol = new Solution();
        TreeNode tn = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn21 = new TreeNode(3);
        tn.right = tn2;
        tn2.left = tn21;
        List<Integer> ans = sol.inorderTraversal(tn);
        System.out.println();
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        TreeNode tn = new TreeNode(3);
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        tn.right = tn2;
        tn.left = tn1;
        List<Integer> ans = sol.inorderTraversal(tn);
        System.out.println();
    }
}

