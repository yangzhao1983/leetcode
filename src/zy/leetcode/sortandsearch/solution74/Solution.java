package zy.leetcode.sortandsearch.solution74;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    private int[][] matrix;
    private int col;
    private int row;
    private int target;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        this.row = matrix.length;
        if(matrix == null || row == 0){
            return false;
        }

        this.col = matrix[row-1].length;

        if(col == 0){
            return false;
        }

        int targetRow = inWhichRow(0, row - 1);
        if(targetRow == -1) return false;
        else return inWhichCol(targetRow, 0, col-1);
    }

    private int inWhichRow(int t, int b){
        if(t == b){
            return target >= matrix[t][0] && target <= matrix[t][col-1]
                    ? t : -1;
        }

        int mid = t + (b -t)/2;
        if(matrix[t][0] <= target && matrix[mid][col-1]>=target){
            return inWhichRow(t, mid);
        }else if(matrix[mid+1][0] <= target && matrix[b][col-1] >= target){
            return inWhichRow(mid+1, b);
        }else{
            return -1;
        }
    }

    private boolean inWhichCol(int row, int left, int right){
        if(left == right){
            return matrix[row][left] == target ? true : false;
        }
        int mid = left + (right - left)/2;

        if(target >= matrix[row][left] && target <= matrix[row][mid]){
            return inWhichCol(row, left, mid);
        }else if(target >= matrix[row][mid+1] && target <=matrix[row][right]){
            return inWhichCol(row, mid+1, right);
        }else{
            return false;
        }

    }

    @Test
    public void test1(){
        int[][] matrix = {{1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        int target = 3;
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.searchMatrix(matrix, 3));
    }
}
