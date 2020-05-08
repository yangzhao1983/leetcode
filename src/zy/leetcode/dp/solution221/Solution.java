package zy.leetcode.dp.solution221;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * if matrix[i][j] = 0,
     * dp[i][j]
     *
     * dp[i][j]: min(m,n) m : number of 1s in vertical direction,
     *  n: number of 1s in horizon direction
     *
     * if dp[i-1][j-1] + 1 = dp[i][j]
     *
     * ans++
     *
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return ans;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i = 0; i<matrix.length;i++){
            dp[i][0] = matrix[i][0] - '0';
            if(dp[i][0] > ans) ans = dp[i][0];
        }

        for(int j = 0; j<matrix[0].length;j++){
            dp[0][j] = matrix[0][j] - '0';
            if(dp[0][j] > ans) ans = dp[0][j];
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                    if(matrix[i][j] == '1'){
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),
                                dp[i-1][j-1]) + 1;
                        if(dp[i][j] > ans){
                            ans = dp[i][j];
                        }
                    }
                }

        }

        return ans * ans;
    }
    
    @Test
    public void test1(){
       char[][] matrix = {
               {'1','0','1','0','0'},
               {'1','0','1','1','1'},{'1','1','1','1','1'},
               {'1','0','0','1','0'}
       };
       Solution sol = new Solution();
       Assert.assertEquals(4, sol.maximalSquare(matrix));
    }

    @Test
    public void test2(){
        char[][] matrix = {
                {'1'}
        };
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.maximalSquare(matrix));
    }

    @Test
    public void test3(){
        char[][] matrix = {
                {'0','1'}
        };
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.maximalSquare(matrix));
    }
}
