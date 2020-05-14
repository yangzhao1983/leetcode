package zy.leetcode.search.solution87;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length == 0){
            return false;
        }else if(nums.length ==1 ){
            return nums[0] == target;
        }
        return doSearch(nums, 0, nums.length-1, target);
    }

    private boolean doSearch(int[] nums, int left, int right, int target){
        if(left == right){
            return nums[left] == target;
        }

        int mid = left + (right - left)/2;

        boolean got = false;

        if(nums[left] < nums[mid] && target <= nums[mid] && target >= nums[mid]){
            got = doSearch(nums, left, mid, target);
        }
        if(got) return true;

        if(nums[mid] < nums[right] && target <= nums[right] && target >= nums[mid]){
            got = doSearch(nums, mid+1, right, target);
        }
        if(got) return true;

        if(doSearch(nums, left, mid, target)) return true;

        return doSearch(nums, mid+1, right, target);
    }

    private boolean doBinarySearch(int[] nums, int left, int right, int target){
        if(left == right){
            return nums[left] == target;
        }

        int mid = left + (right - left)/2;

        if(target < nums[left] || target > nums[right]){
            return false;
        }else if (target <= nums[mid]){
            if(doBinarySearch(nums, left, mid,target)) return true;
        }

        return doBinarySearch(nums, mid+1, right, target);
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        Assert.assertEquals(true, sol.search(nums, target));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;
        Assert.assertEquals(false, sol.search(nums, target));
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        int[] nums = {2,2,3,0,0,1,2};
        int target = 3;
        Assert.assertEquals(true, sol.search(nums, target));
    }
}
