package zy.leetcode.dp.solution64;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                if(i==0 && j==0){
                    ans[i][j] = grid[i][j];
                }else{
                    int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if(i > 0){
                        top = ans[i-1][j];
                    }
                    if(j > 0){
                        left = ans[i][j-1];
                    }
                    ans[i][j] = Math.min(top, left) + grid[i][j];
                }
            }
        }

        return ans[ans.length-1][ans[0].length-1];
    }

    @Test
    public void test1(){
        int[][] grid = {  {1,3,1},
                {1,5,1},
        {4,2,1}};
        Solution sol = new Solution();
        Assert.assertEquals(7, sol.minPathSum(grid));
    }
}
