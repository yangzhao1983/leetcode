package zy.leetcode.dp.solution322;

import java.util.*;

public class Solution {

    // status change formula
    // status: for dp[n], dp[n] = min_coin_num(i) given coin[i] + dp[n-coin[i]]
    // change dp[n] = min_coin_num(i) given coin[i] + dp[n-coin[i]]
    // optimal
    // aftereffect
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++){
            getOptimalCoin(dp, i, coins);
        }

        return dp[amount];

    }

    private void getOptimalCoin(int[] dp, int index, int[] coins){
        int optimalCoinNum = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++){
            if(index >= coins[i] && dp[index - coins[i]] > -1){
                int coinsNum = 1 + dp[index - coins[i]];
                if(coinsNum < optimalCoinNum){
                    optimalCoinNum = coinsNum;
                }
            }
        }
        if(optimalCoinNum < Integer.MAX_VALUE){
            dp[index] = optimalCoinNum;
        }
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{1,2,5}, 11));
    }

    private static void test2(){
        Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{2}, 3));
    }

    public static void main(String...strings){
        test1();
        test2();
    }
}
