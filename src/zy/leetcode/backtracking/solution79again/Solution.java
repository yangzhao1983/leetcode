package zy.leetcode.backtracking.solution79again;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    private boolean[][] visited;
    private String word;
    private boolean found = false;
    private char[][] board;
    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        int m = board.length;
        int n = board[0].length;
        this.visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                doBacktracking(j, i, "");
                if(found) return true;
            }
        }
        return false;
    }

    private void doBacktracking(int col, int row, String str){
        if(found) return;

        if(visited[row][col]) return;

        int cur = str.length();
        if(this.word.charAt(cur) != board[row][col]) return;

        str = str + String.valueOf(board[row][col]);

        if(str.equals(this.word)){
            found = true;
            return;
        }

        visited[row][col] = true;

        // top
        if(row > 0) doBacktracking(col, row - 1, str);
        if(found) return;

        // bottom
        if(row < board.length-1 ) doBacktracking(col, row + 1, str);
        if(found) return;

        // left
        if(col > 0) doBacktracking(col - 1, row, str);
        if(found) return;

        // right
        if(col < board[0].length-1) doBacktracking(col + 1, row, str);
        if(found) return;

        visited[row][col] = false;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        char[][] board = {
                { 'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        Assert.assertEquals(true, sol.exist(board, word));
    }
}
