package zy.leetcode.dp.solution123;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1) return 0;
        int n = prices.length;
        int[] dpL = new int[n+1];
        int[] dpR = new int[n+1];
        dpL[0] = 0;
        dpL[1] = 0;
        int min = prices[0];
        for(int i = 2; i < n+1; i++){
            if(prices[i-1] < min){
                min = prices[i-1];
            }
            dpL[i] = Math.max(prices[i-1] - min, dpL[i-1]);
        }

        int max = prices[n-1];
        dpR[n] = 0;
        dpR[n-1] = 0;

        for(int i = n - 2; i >=0; i--){
            if(prices[i] > max){
                max = prices[i];
            }
            dpR[i] = Math.max(max - prices[i], dpR[i+1]);
        }

        int ans = 0;

        for(int i = 0; i <n;i++){
            int income = dpL[i] + dpR[i];
            if(income > ans) ans = income;
        }
        return ans;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {1,2};
        Assert.assertEquals(1, sol.maxProfit(nums));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        int[] nums = {3,3,5,0,0,3,1,4};
        Assert.assertEquals(6, sol.maxProfit(nums));
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        int[] nums = {1,7,4,2,11};
        Assert.assertEquals(15, sol.maxProfit(nums));
    }
}
