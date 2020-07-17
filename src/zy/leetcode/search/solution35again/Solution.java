package zy.leetcode.search.solution35again;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums ==null || nums.length == 0) return 0;
        return doBS(nums, 0, nums.length - 1, target);
    }

    private int doBS(int[] nums, int l, int r, int target){
        if(l == r){
            if(nums[l] >= target)return l;
            else return l+1;
        }

        int mid = l + (r - l)/2;
        if(nums[mid] == target) return mid;
        else if (nums[mid] > target) return doBS(nums, l, mid-1 >= l ? (mid-1) : l, target);
        else return doBS(nums, mid+1 <= r ?mid+1:r, r,target);
    }
}
