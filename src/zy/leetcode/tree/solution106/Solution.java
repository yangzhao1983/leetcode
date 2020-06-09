package zy.leetcode.tree.solution106;

import zy.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Integer, Integer> pos = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length==0) return null;
        for(int i = 0; i < inorder.length; i++){
            pos.put(inorder[i], i);
        }

        return doBuildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    private TreeNode doBuildTree(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        // the last item in postorder[ps, pe] is root
        // get index of postorder_last from inorder as index, separate two arrays
        if (ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pe]);

        int index = getIndex(postorder[pe]);

        root.left = doBuildTree(inorder, postorder, is, index - 1, ps, ps + index - is - 1);
        root.right = doBuildTree(inorder, postorder, index + 1, ie, ps + index - is, pe-1);
        return root;
    }

    private int getIndex(int val){
        return pos.get(val);
    }
}
