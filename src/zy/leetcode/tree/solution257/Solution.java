package zy.leetcode.tree.solution257;

import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final String SEP = "->";

    private List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        doDFS(root, "");
        return ans;
    }

    private void doDFS(TreeNode root, String path){
        if(root == null) return;

        if(path.length() == 0) path = String.valueOf(root.val);
        else path = path + SEP + root.val;

        if(root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        doDFS(root.left, path);
        doDFS(root.right, path);
    }
}
