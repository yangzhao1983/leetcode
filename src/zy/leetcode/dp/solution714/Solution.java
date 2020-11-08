package zy.leetcode.dp.solution714;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int p0 = 0;
        int p1 = -prices[0];

        for(int i = 0; i < prices.length; i++){
            int tmp = p0;
            p0 = Math.max(p0, p1 + prices[i] - fee);
            p1 = Math.max(p1, p0 - prices[i]);
        }

        return Math.max(p0, p1);
    }
}
