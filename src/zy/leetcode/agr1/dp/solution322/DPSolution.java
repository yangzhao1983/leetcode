package zy.leetcode.agr1.dp.solution322;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiser_zhao on 2019/9/19.
 */
public class DPSolution {

    public static void main(String...strings){
        testcase1();
    }

    private static void testcase1(){
        int[] nums = {1, 2, 5};
        System.out.println(coinChange(nums, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }

        if(coins.length == 1){
            if (amount % coins.length == 0){
                return amount/coins.length;
            }else{
                return -1;
            }
        }

        int[][] dp = new int[amount + 1][amount + 1];

        for(int i = 0; i <= amount; i++){
            for(int j = 0; j<=amount; j++){
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0;

        for(int i = 1; i<= amount; i++){
            for(int j = 0; j<=amount; j++){
                List<Integer> items = new ArrayList<>();
                if(dp[i-1][j]>=0){
                    items.add(dp[i-1][j]);
                }

                if(j>=1 && dp[i-1][j-1] >= 0){
                    items.add(dp[i-1][j-1] + 1);
                }

                if(j>=2 && dp[i-1][j-2] >= 0){
                    items.add(dp[i-1][j-2] + 1);
                }

                if(j>=5 && dp[i-1][j-5] >= 0){
                    items.add(dp[i-1][j-5] + 1);
                }

                if (items.size() > 0) {
                    dp[i][j] = min(items);
                }
            }
        }

        int minCoins = Integer.MAX_VALUE;
        for(int i = amount; i >=0; i--){
            if(dp[i][amount] < minCoins && dp[i][amount] > 0){
                minCoins = dp[i][amount];
            }
        }
        if(minCoins == Integer.MAX_VALUE){
            return -1;
        }

        return minCoins;
    }

    private static int min(List<Integer> items){
        int min = Integer.MAX_VALUE;
        for(int item : items){
            if (item < min){
                min = item;
            }
        }
        return min;
    }
}
