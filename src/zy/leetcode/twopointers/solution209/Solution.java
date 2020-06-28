package zy.leetcode.twopointers.solution209;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int forward = 0;
        int backward = 1;
        int sum = nums[0];
        int ans = Integer.MAX_VALUE;
        while(true){
            if(sum >= s && forward < backward){
                ans = Math.min(ans, backward-forward);
                sum -= nums[forward];
                forward++;
            }else{
                if(backward == nums.length)break;
                else{
                    sum += nums[backward];
                    backward++;
                }
            }
        }
        return forward==0? 0:ans;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {2,3,1,2,4,3};
        Assert.assertEquals(2,sol.minSubArrayLen(7,nums));
    }
}
