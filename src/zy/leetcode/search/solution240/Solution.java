package zy.leetcode.search.solution240;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        // diagonal
        int m = matrix.length;
        int n =matrix[0].length;
        int curRow = m-1;
        int curCol = 0;

        boolean ans = false;

        while(curRow < m && curRow >=0 && curCol < n && curCol >=0){
            int cur = matrix[curRow][curCol];
            if(cur == target){
                ans = true;
                break;
            }else if(cur > target){
                curRow--;
            }else{
                curCol++;
            }
        }
        return ans;
    }
}
