package zy.leetcode.tree.solution108;

import org.junit.Test;
import zy.leetcode.tree.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length == 0){
            return null;
        }
        return doGen(nums, 0, nums.length-1);
    }

    private TreeNode doGen(int[] nums, int l, int r){
        if(l > r){
            return null;
        }

        int mid = (r+l+1)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = doGen(nums, l, mid-1);
        root.right = doGen(nums, mid+1, r);

        return root;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sol.sortedArrayToBST(nums);
        System.out.println();
    }
}
