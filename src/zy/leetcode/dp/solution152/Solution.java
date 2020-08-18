package zy.leetcode.dp.solution152;

public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[][] dp = new int[n][n];
        int ans = Integer.MIN_VALUE;

        for(int step = 1; step <= n; step++){
            for(int i = 0; i <= n-step; i++){
                if(step==1) dp[i][i+step-1] = nums[i];
                else dp[i][i+step-1] = dp[i][i+step-2] * nums[i+step-1];
                if(dp[i][i+step-1] > ans) ans = dp[i][i+step-1];
            }
        }
        return ans;
    }
}
