package zy.leetcode.dp.solution309;

public class Solution {
    /**
     * dp[i][0] the income after day i, if hold stock
     *  two cases:
     *      1. in day i-1, hold stock, dp[i-1][0]
     *      2. in day i-1, hold no stock, and it is not cool down day after day i+1, dp[i-1][2] - prices[i]
     * dp[i][1] the income after day i, if hold no stock and it is cool down day after day i (obviously, the stock is sold)
     *      1. in day i-1, hold stock dp[i-1][0] + prices[i]
     * dp[i][2] the income after day i, if hold no stock and it is not cool down day after day
     *      1. after day i-1, not cool down day, dp[i-1][1]
     *      2. after day i-1, cool down day, dp[i-1][2]
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;

        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for(int i = 1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }

        return Math.max(dp[n-1][1], dp[n-1][2]);
    }
}
