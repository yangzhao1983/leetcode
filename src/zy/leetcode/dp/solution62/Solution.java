package zy.leetcode.dp.solution62;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0){
            return 0;
        }

        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i==0 && j==0){
                    ans[i][j] = 1;
                }else{
                    if(i>0)ans[i][j] += ans[i-1][j];
                    if(j>0)ans[i][j] += ans[i][j-1];
                }
            }
        }
        return ans[m-1][n-1];
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(3, sol.uniquePaths(3,2));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals(28, sol.uniquePaths(7,3));
    }
}
