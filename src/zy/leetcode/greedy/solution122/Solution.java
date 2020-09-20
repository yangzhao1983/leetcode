package zy.leetcode.greedy.solution122;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <=1) return 0;

        int dp0 = 0;
        int dp1 = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return Math.max(dp0, dp1);
    }

    @Test
    public void test1(){
        int[] prices = {1,2,3};
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.maxProfit(prices));
    }
}
