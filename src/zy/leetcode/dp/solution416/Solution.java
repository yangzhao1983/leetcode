package zy.leetcode.dp.solution416;

public class Solution {
    /**
     * for each i, nums[i] can be selected or not.
     *
     * brute: (start, target) => (start+1, target) or (start+1, target - nums[start])
     *
     * sort nums, select nums[i]
     *
     * target = target - nums[i]
     *
     * nums[0-j], nums[j] <= target
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        int max = 0;
        for(int num : nums){
            sum += num;
            if(num > max) max = num;
        }
        if(sum%2==1) return false;
        int target = sum/2;
        if(max > target) return false;

        boolean[][] dp = new boolean[n][target+1];
        for(int i = 0; i < n;i++){
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;

        for(int i = 1; i < n; i++){
            int num = nums[i];
            for(int j = 1; j<=target;j++){
                if(num <= j){
                    dp[i][j] = dp[i-1][j-num] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }
}
