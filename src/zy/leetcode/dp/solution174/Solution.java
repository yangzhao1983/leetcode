package zy.leetcode.dp.solution174;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null || dungeon.length==0 || dungeon[0].length==0) return 0;
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for(int i = n-1; i>=0; i--){
            for(int j = m-1; j>=0; j--){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = n-1; i>=0; i--){
            for(int j = m-1; j>=0; j--){
                if(i == n-1 && j==m-1) {
                    if(dungeon[i][j] <0) dp[i][j] = Math.abs(dungeon[i][j]) + 1;
                    else dp[i][j] = 1;
                }else{
                    int down = Integer.MAX_VALUE;
                    int right = Integer.MAX_VALUE;
                    if(i < n-1){
                        down = getMinVal(dp[i+1][j], dungeon[i][j]);
                    }
                    if(j < m-1){
                        right = getMinVal(dp[i][j+1], dungeon[i][j]);
                    }
                    dp[i][j] = Math.min(Math.min(dp[i][j], down),right);
                }
            }
        }
        return dp[0][0];
    }

    private int getMinVal(int nextVal, int curVal){
        return (nextVal - curVal) > 0 ? (nextVal-curVal) : 1;
    }
}
