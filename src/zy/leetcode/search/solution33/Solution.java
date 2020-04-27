package zy.leetcode.search.solution33;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        return doReverseBinarySearch(nums, target, 0, nums.length -1);
    }

    private int doReverseBinarySearch(int[] nums, int target, int start, int end){
        if(start == end){
            return nums[start] == target ? start : -1;
        }
        int mid = start + (end-start)/2;

        int rel = -1;
        if(nums[start] > nums[mid]){
            rel = doReverseBinarySearch(nums, target, start, mid);
        }else{
            rel = doNormalBinarySearch(nums, target,start,mid);
        }

        if(rel != -1) return rel;

        if(nums[mid+1] > nums[end]){
            rel = doReverseBinarySearch(nums, target,mid+1, end);
        }else{
            rel = doNormalBinarySearch(nums, target,mid+1,end);
        }

        return rel;
    }

    private int doNormalBinarySearch(int[] nums, int target, int start, int end){
        if(start == end){
            return nums[start] == target ? start : -1;
        }

        if(target > nums[end] || target < nums[start]){
            return -1;
        }

        int mid = start + (end - start)/2;

        int rel = doNormalBinarySearch(nums, target, start, mid);
        if(rel != -1) return rel;

        rel = doNormalBinarySearch(nums, target, mid + 1, end);
        return rel;
    }

    @Test
    public void test1(){
        int[] nums = {4,5,6,7,0,1,2};
        Solution sol = new Solution();
        Assert.assertEquals(4, sol.search(nums, 0));
    }
}
