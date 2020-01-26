package zy.leetcode.dp.solution300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int maxLen = 0;
        // dp[i] = dp[j] + 1, max(dp[j]), j in [0..i-1], nums[j-1] < nums[i-1]
        dp[0] = 0;
        for(int i = 1; i<dp.length; i++){
            int maxIndex = findMax(nums, i, dp);
            dp[i] = maxIndex ==-1? 1 : dp[maxIndex] + 1;
            if (dp[i] > maxLen){
                maxLen = dp[i];
            }
        }
        return maxLen;
    }

    private int findMax(int[] nums, int target, int[] dp){
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for(int i = target - 1; i > 0; i--){
            if(nums[i-1] < nums[target-1]){
                if(dp[i] > max){
                    max = dp[i];
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }

    private static void test1(){
        System.out.println(new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    private static void test2(){
        System.out.println(new Solution().lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }

    private static void test3(){
        System.out.println(new Solution().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

    public static void main(String...strings){
        test3();
    }
}
