package zy.leetcode.tree.solution96;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    private int[][] dp;
    public int numTrees(int n) {
        dp = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < n+1; j++){
                if(i>=j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return doNumTrees(1, n);
    }
    private int doNumTrees(int start, int end){

        if(start == dp.length){
            return 1;
        }

        if (dp[start][end] == 0){
            int rel = 0;
            for(int i = start; i<=end; i++){
                int leftNum = doNumTrees(start, i-1);

                int rightNum = doNumTrees(i+1, end);

                rel += leftNum * rightNum;
            }
            dp[start][end] = rel;
        }
        return dp[start][end];
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(5, sol.numTrees(3));
    }

    @Test
    public void test0(){
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.numTrees(0));
    }
}
