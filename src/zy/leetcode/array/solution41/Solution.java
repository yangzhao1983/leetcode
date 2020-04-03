package zy.leetcode.array.solution41;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution {
    /**
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        // if no 1 return 1
        int oneCount = 0;
        for(int num : nums){
            if(num ==1 ) {
                oneCount++;
                break;
            }
        }
        if(oneCount == 0){
            return 1;
        }

        // nums[i] =>1, if nums[i] < = 0, > n
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0|| nums[i] > nums.length) nums[i] = 1;
        }

        // if a= nums[i] exist, nums[a] = - nums[a]
        for(int i = 0; i < nums.length; i++){
            int a = Math.abs(nums[i]);
            if(a == nums.length)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }

        for(int i = 1; i<nums.length;i++){
            if(nums[i] > 0){
                return i;
            }
        }

        if(nums[0] > 0){
            return nums.length;
        }

        return nums.length + 1;
    }

    @Test
    public void test1(){
        int[] nums = {1,2,0};
        Solution sol = new Solution();
        int ans = sol.firstMissingPositive(nums);
        Assert.assertEquals(3,ans);
    }

    @Test
    public void test2(){
        int[] nums = {3,4,-1,1};
        Solution sol = new Solution();
        int ans = sol.firstMissingPositive(nums);
        Assert.assertEquals(2,ans);
    }

    @Test
    public void test3(){
        int[] nums = {7,8,9,11,12};
        Solution sol = new Solution();
        int ans = sol.firstMissingPositive(nums);
        Assert.assertEquals(1,ans);
    }

    @Test
    public void test4(){
        int[] nums = {2147483647};
        Solution sol = new Solution();
        int ans = sol.firstMissingPositive(nums);
        Assert.assertEquals(1,ans);
    }
}
