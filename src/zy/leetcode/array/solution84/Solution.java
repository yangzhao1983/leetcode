package zy.leetcode.array.solution84;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights== null || heights.length == 0){
            return 0;
        }

        // min：Unilateral matrix，min[i][j] contains the minimum val of heights[i] ~ heights[j]
        int[][] min = new int[heights.length][heights.length];

        int max = 0;
        for(int i = 0; i < heights.length;i++){
            min[i][i] = heights[i];
            if(min[i][i] > max) max = min[i][i];
        }

        for(int i = 1; i < heights.length; i++){
            for(int j = 0; j < heights.length- i;j++){
                min[j][j+i] = Math.min(min[j][j+i-1], heights[j+i]);
                int area = (i+1) * min[j][j+i];
                if(area > max){
                    max = area;
                }

            }
        }
        return max;
    }

    @Test
    public void test1(){
        int[] heights = {2,1,5,6,2,3};
        Solution sol = new Solution();
        Assert.assertEquals(10, sol.largestRectangleArea(heights));
    }

    @Test
    public void test2(){
        int[] heights = {0,9};
        Solution sol = new Solution();
        Assert.assertEquals(9, sol.largestRectangleArea(heights));
    }
}
