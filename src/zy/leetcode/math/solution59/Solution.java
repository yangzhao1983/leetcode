package zy.leetcode.math.solution59;

import org.junit.Test;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int start = 1;
        int end = n * n;
        int top = 0, bottom=n-1, left = 0, right = n-1;
        while(start <= end){
            for(int i = left; i <= right; i++){
                ans[top][i] = start++;
            }
            top++;
            for(int i = top; i <= bottom; i++){
                ans[i][right] = start++;
            }
            right--;
            for(int i = right; i>=left; i--){
                ans[bottom][i] = start++;
            }
            bottom--;
            for(int i = bottom; i>=top; i--){
                ans[i][left] = start++;
            }
            left++;
        }
        return ans;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[][] ans = sol.generateMatrix(3);
        System.out.println();
    }
}
