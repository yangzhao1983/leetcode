package zy.leetcode.dp.solution152again;

public class Solution {
    public int maxProduct(int[] nums) {
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMin[0] = dpMax[0] = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            dpMax[i] = Math.max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]);
            dpMax[i] = Math.max(dpMax[i], nums[i]);

            dpMin[i] = Math.min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]);
            dpMin[i] = Math.min(dpMin[i], nums[i]);

            if(dpMax[i] > ans) ans = dpMax[i];
        }

        return ans;
    }
}
