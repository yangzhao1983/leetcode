package zy.leetcode.math.solution54;

import org.junit.Test;
import zy.leetcode.linked.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int N_HOR;
    private int N_VER;
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        int i = matrix.length;

        if(i==0){
            return ans;
        }

        int j = matrix[0].length;

        if(j==0){
            return ans;
        }

        N_HOR = matrix.length;
        N_VER = matrix[0].length;

        while( i > matrix.length/2 && j> matrix[0].length/2){
            calMargin(i, j, matrix);
            i--;
            j--;
        }
        return ans;
    }

    private void calMargin(int i, int j, int[][] matrix){
        if( i-1 == N_HOR-i){
            for(int k = N_VER - j; k <= j-1; k++){
                ans.add(matrix[i-1][k]);
            }
            return;
        }else if(j-1 == N_VER - j){
            for(int k = N_HOR-i; k <= i-1; k++){
                ans.add(matrix[k][j-1]);
            }
            return;
        }

        // top
        for(int k = N_VER - j; k < j - 1; k++){
            ans.add(matrix[N_HOR-i][k]);
        }

        // right
        for(int k = N_HOR-i; k < i-1;k++){
            ans.add(matrix[k][j-1]);
        }

        // bottom
        for(int k = j-1; k > N_VER-j;k--){
            ans.add(matrix[i-1][k]);
        }

        // left
        for(int k = i-1; k > N_HOR-i;k--){
            ans.add(matrix[k][N_VER-j]);
        }
    }

    @Test
    public void test1(){
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Solution sol = new Solution();
        List<Integer> ans = sol.spiralOrder(matrix);
        System.out.println();
    }

    @Test
    public void test2(){
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };

        Solution sol = new Solution();
        List<Integer> ans = sol.spiralOrder(matrix);
        System.out.println();
    }
}
