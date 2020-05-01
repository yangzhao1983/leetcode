package zy.leetcode.dp.solution53;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(sum[i-1] < 0){
                sum[i] = nums[i];
            }else{
                sum[i] = sum[i-1] + nums[i];
            }
            if(sum[i] > ans){
                ans= sum[i];
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(6, sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.maxSubArray(new int[]{-2,1}));
    }
}
