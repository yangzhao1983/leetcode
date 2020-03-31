package zy.leetcode.search.solution35;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            if(left == right){
                break;
            }
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(nums[left] >= target){
            return left;
        }else{
            return left + 1;
        }
    }
    /**
     * left, mid, right
     * target == a[mid], return
     * target < a[mid] [left, mid]
     * target > a[mid] [mid, right]
     *
     *
     */
    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.searchInsert(new int[]{1,3,5,6}, 5));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.searchInsert(new int[]{1,3,5,6}, 2));
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        Assert.assertEquals(4, sol.searchInsert(new int[]{1,3,5,6}, 7));
    }
}
