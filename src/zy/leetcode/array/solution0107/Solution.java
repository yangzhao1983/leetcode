package zy.leetcode.array.solution0107;

import org.junit.Test;

import javax.management.StandardEmitterMBean;

public class Solution {
    /***
     * top:
     * [i,j ]-> [ j,len-i-1]
     *
     * right
     * [i, j] -> [j, len - 1 -i]
     * [j, len-i-1] -> [len-i-1, len-1-j]
     *
     * bottom
     * [i, j] -> [ j , len-1-i]
     *
     * [len-i-1, len-1-j] -> [len-1-j, i]
     *
     * left
     * [i, j] -> [j, len - 1 -i]
     *
     * [len-1-j,i] -> [i, j]
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i <= (len-1)/2;i++){
            for(int j = i; j < len - i-1;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-i-1][len-1-j];
                matrix[len-i-1][len-1-j] = matrix[j][len-1-i];
                matrix[j][len-1-i] = tmp;
            }
        }
    }

    @Test
    public void test1(){
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Solution sol = new Solution();
        sol.rotate(matrix);
        System.out.println();
    }

    @Test
    public void test2(){
        int[][] matrix = {
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        Solution sol = new Solution();
        sol.rotate(matrix);
        System.out.println();
    }
}
