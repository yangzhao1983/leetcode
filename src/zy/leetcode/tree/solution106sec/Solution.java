package zy.leetcode.tree.solution106sec;

import org.junit.Test;
import zy.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int[] inorder;
    private int[] postorder;
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null) return null;
        this.inorder = inorder;
        this.postorder = postorder;
        for(int i = 0; i <inorder.length; i++){
            map.put(inorder[i], i);
        }
        return doBuild(0, inorder.length-1, 0, postorder.length-1);
    }

    private TreeNode doBuild(int inS, int inE, int postS, int postE){
        if(postE < postS) return null;
        TreeNode cur = new TreeNode(postorder[postE]);
        if(postS == postE) return cur;

        int inMid = map.get(postorder[postE]);

        cur.left = doBuild(inS, inMid - 1, postS, postS + (inMid - 1-inS));
        cur.right = doBuild(inMid + 1, inE, postS + (inMid-inS), postE-1);

        return cur;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = sol.buildTree(inorder, postorder);
        System.out.println();
    }
}
