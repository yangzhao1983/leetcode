package zy.leetcode.dp.solution63;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length==0|| obstacleGrid[0].length==0){
            return 0;
        }

        int[][] ans = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[i].length;j++){
                if(obstacleGrid[i][j] == 1){
                    ans[i][j] = 0;
                }else{
                    if(i==0 &&  j== 0){
                        ans[i][j] = 1;
                    }else{
                        if(i > 0){
                            ans[i][j] += ans[i-1][j];
                        }
                        if(j > 0){
                            ans[i][j] += ans[i][j-1];
                        }
                    }
                }
            }
        }
        return ans[ans.length-1][ans[0].length-1];
    }

    @Test
    public void test1(){
        int[][] input = { {0,0,0},
                {0,1,0},
                {0,0,0}};

        Solution sol = new Solution();

        Assert.assertEquals(2, sol.uniquePathsWithObstacles(input));
    }
}
