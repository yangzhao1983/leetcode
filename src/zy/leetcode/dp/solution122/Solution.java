package zy.leetcode.dp.solution122;

public class Solution {
    /**
     * h[i] hold stock
     * hn[i] hold no stock
     *
     * h[0]= -prices[i]
     * hn[0]=0
     *
     *
     * h[i+1]: h[i], hn[i] - prices[i]
     * hn[i+1]: hn[i], h[i]+prices[i]
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int p1 = -prices[0];
        int p0 = 0;
        for(int i = 1; i < prices.length; i++){
            int tmp = p1;
            p1 = Math.max(p1, p0 - prices[i]);
            p0 = Math.max(p0, p1 + prices[i]);
        }
        return Math.max(p0, p1);
    }
}
