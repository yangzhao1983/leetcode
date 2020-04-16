package zy.leetcode.dp.solution55;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * for each num[i], check j [1, num[i]], if nums[j] is true, then num is true
     * i [0, i-2]
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        boolean[] accessible = new boolean[nums.length];
        accessible[nums.length-1] = true;
        for(int i = nums.length -2; i>=0; i--){
            for(int j = 1; j <= nums[i]; j++){
                if(accessible[i +j]){
                    accessible[i] = true;
                    break;
                }
            }
        }
        return accessible[0];
    }

    @Test
    public void test1(){
        int[] nums = {2,3,1,1,4};
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.canJump(nums));
    }

    @Test
    public void test2(){
        int[] nums = {3,2,1,0,4};
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.canJump(nums));
    }
}
