package zy.leetcode.tree.solution145thi;

import zy.leetcode.tree.TreeNode;

import java.util.*;


public class Solution {
    Set<TreeNode> visited = new HashSet<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (allChildVisited(cur)) {
                ans.add(cur.val);
                visited.add(cur);
                stack.pop();
            } else {
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
        }
        return ans;
    }

    private boolean allChildVisited(TreeNode treeNode) {
        if ((treeNode.left == null || visited.contains(treeNode.left)) && (treeNode.right == null ||
                visited.contains(treeNode.right))) {
            return true;
        } else {
            return false;
        }
    }
}
