package zy.leetcode.search.solution153;

public class Solution {
    public int findMin(int[] nums) {
        return doFindMin(nums, 0, nums.length-1);
    }

    private int doFindMin(int[] nums, int l, int r){
        if(nums[l] <= nums[r]) return nums[l];
        else if (l+1 == r) return Math.min(nums[l], nums[r]);

        int mid = l + (r-l)/2;
        if(nums[l] < nums[mid] && nums[mid] < nums[r]) return nums[l];
        else if(nums[l] > nums[mid]) return doFindMin(nums, l, mid);
        else return doFindMin(nums, mid, r);
    }
}
