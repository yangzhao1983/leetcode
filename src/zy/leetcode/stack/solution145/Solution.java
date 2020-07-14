package zy.leetcode.stack.solution145;

import org.junit.Test;
import zy.leetcode.tree.TreeNode;

import java.util.*;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if ((top.left == null && top.right == null) || ((visited.contains(top.left) || top.left == null) &&
                    (visited.contains(top.right) || top.right == null))) {
                TreeNode cur = stack.pop();
                ans.add(cur.val);
                visited.add(cur);
            }
            if (top.right != null && !visited.contains(top.right)) {
                stack.push(top.right);
            }

            if (top.left != null && !visited.contains(top.left)) {
                stack.push(top.left);
            }
        }

        return ans;
    }

    @Test
    public void test1() {
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn12 = new TreeNode(2);
        TreeNode tn121 = new TreeNode(3);
        tn1.right = tn12;
        tn12.left = tn121;
        Solution sol = new Solution();
        List<Integer> ans = sol.postorderTraversal(tn1);
        System.out.println();
    }
}
