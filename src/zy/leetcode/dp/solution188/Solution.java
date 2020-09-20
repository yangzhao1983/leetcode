package zy.leetcode.dp.solution188;

public class Solution {
    public int maxProfit(int k, int[] prices) {

        if(prices==null || prices.length==0) {
            return 0;
        }

        int n = prices.length;
        if(k >= n/2){
            int dp0 = 0;
            int dp1 = -prices[0];
            for(int i = 1; i < n; i++){
                dp0 = Math.max(dp0, dp1 + prices[i]);
                dp1 = Math.max(dp1, dp0 - prices[i]);
            }
            return Math.max(dp0, dp1);
        }

        int[][] p = new int[k + 1][2];
        for(int i = 0; i <= k; i++)p[i][1] = -prices[0];
        for(int i = 1; i < n; i++){
            for(int j = k; j>0; j--){
                p[j-1][1] = Math.max(p[j-1][1], p[j-1][0]-prices[i]);
                p[j][0] = Math.max(p[j][0], p[j-1][1]+prices[i]);
            }
        }
        return p[k][0];
    }
}
