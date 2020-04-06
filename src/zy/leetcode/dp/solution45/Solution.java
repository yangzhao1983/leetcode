package zy.leetcode.dp.solution45;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution {
    /**
     * dp[len]
     *
     * dp[i], minimum steps from nums[i] to nums[len-1]
     * dp[len-1] = 0.
     *
     * for i [1, nums[i]]
     * dp[i] = min(nums[i+1]+1, nums[i+2]+1, ..nums[i+nums[i]]+1)
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if(nums==null && nums.length<=1){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        for(int i = nums.length-2; i>=0;i--){
            if(nums[i] == 0){
                dp[i] = Integer.MAX_VALUE;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int j = 1; j<=nums[i] && i+j <nums.length;j++){
                if(dp[i+j] <min - 1){
                    min = dp[i+j]+1;
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }

    @Test
    public void test1(){
        int[] nums = {2,3,1,1,4};
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.jump(nums));
    }

    @Test
    public void test2(){
        int[] nums = {2,3,0,1,4};
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.jump(nums));
    }
}
