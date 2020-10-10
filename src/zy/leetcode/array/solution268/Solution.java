package zy.leetcode.array.solution268;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * 1~n, no 0: nums[0] >0 OK
     * 0~n-1:no nums[i] > 0, return n.
     *
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;
        boolean hasN = false;
        for(; i < n; i++ ){
            int val = Math.abs(nums[i]);
            if(val == n) {
                hasN = true;
                continue;
            }
            nums[val] = -1 * nums[val];
        }
        if(!hasN) return n;
        int zero = -1;
        for(i = 0; i < n; i++){
            if(nums[i] > 0) return i;
            if(nums[i]== 0) zero = i;
        }
        return zero;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(0, sol.missingNumber(new int[]{1,2}));
    }
}
