package zy.leetcode.array.solution73;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * 1. find the first line containing 0
     * 2. record the cols with 0, set all of the cells to 0, set zero for previous lines
     * 3. for the next line, if it contains 0, record it, set all of the cells to 0
     *                       else, set the cols to 0, where the lines are listed in the record
     *
     * @param matrix
     */

    private Set<Integer> colsWithZero = new HashSet<>();

    public void setZeroes(int[][] matrix) {
        int row = 0;
        for(; row<matrix.length; row++){
            if(rowContainsZero(matrix, row)){
                setZeroForRow(matrix, row, true);
            }
        }

        for(row =0;row < matrix.length; row++){
            if(matrix[row][0]!=0){
                setZeroForRow(matrix, row, false);
            }
        }
    }

    private void setZeroForRow(int[][] matrix, int row, boolean containsZero){

        if(containsZero){
            for(int col = 0; col < matrix[row].length; col++){
                if(matrix[row][col]!=0) matrix[row][col] = 0;
            }
        }else{
            for(int col:  colsWithZero){
                matrix[row][col] = 0;
            }
        }
    }

    private boolean rowContainsZero(int[][] matrix, int row){
        boolean containsZero = false;
        for(int col=0; col < matrix[row].length; col++){
            if(matrix[row][col]==0){
                if(!containsZero){
                    containsZero = true;
                }
                colsWithZero.add(col);
            }
        }
        return containsZero;
    }

    @Test
    public void test1() {
        int[][] matrix = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        Solution sol = new Solution();
        sol.setZeroes(matrix);
        System.out.println();
    }

    @Test
    public void test2() {
        int[][] matrix = {{0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};
        Solution sol = new Solution();
        sol.setZeroes(matrix);
        System.out.println();
    }

    @Test
    public void test3() {
        int[][] matrix = {{0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};
        Solution sol = new Solution();
        sol.setZeroes(matrix);
        System.out.println();
    }
}
