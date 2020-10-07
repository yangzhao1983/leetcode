package zy.leetcode.dp.solution213;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * loose the limitation:
     * no circle. total[i] = max(total[i-1], total[i-2] + amt[i])
     *
     * add the limitation
     * do dp twice.
     * 1. robber the first house
     * 2. not robber the first house
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return  nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int n = nums.length;

        int dp1[] = new int[n];
        dp1[0] = nums[0];
        dp1[1] = nums[0];
        for( int i= 2; i < n-1; i++){
            dp1[i] = Math.max(dp1[i-2] + nums[i], dp1[i-1]);
        }

        int dp2[] = new int[n];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for( int i= 2; i < n; i++){
            dp2[i] = Math.max(dp2[i-2] + nums[i], dp2[i-1]);
        }

        return Math.max(dp1[n-2], dp2[n-1]);
    }

    @Test
    public void test1(){
        int[] nums = {4,1,2,7,5,3,1};
        Solution sol = new Solution();
        Assert.assertEquals(14, sol.rob(nums));
    }
}
