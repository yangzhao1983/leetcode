package zy.leetcode.bst.solution108;

import zy.leetcode.tree.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length == 0){
            return null;
        }
        return buildBST(nums, 0, nums.length-1);
    }

    private TreeNode buildBST(int[] nums, int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start)/2;

        TreeNode root = new TreeNode(nums[mid]);

        TreeNode l = buildBST(nums, start, mid -1);
        TreeNode r = buildBST(nums, mid+1, end);

        root.left = l;
        root.right = r;

        return root;
    }
}
