package zy.leetcode.backtracking.solution79;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    private char[][] board;
    private String word;
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0){
            return true;
        }

        this.board = board;
        this.word = word;
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                visited[i][j] = true;
                if(backtracking(i, j, 0)) return true;
                visited[i][j] = false;
            }
        }
        return false;
    }

    private boolean backtracking(int h, int v, int index){

        if(word.charAt(index) != board[h][v]){
            return false;
        }

        if(index == word.length()-1){
            return true;
        }

        boolean rel = false;
        if(h > 0 && !visited[h-1][v]){
            visited[h-1][v] = true;
            rel = backtracking(h-1, v, index+1);
            visited[h-1][v] = false;
        }
        if(rel) return true;

        if(v > 0 && !visited[h][v-1]){
            visited[h][v-1] = true;
            rel = backtracking(h, v-1, index+1);
            visited[h][v-1] = false;
        }
        if(rel) return true;

        if(v < board[h].length-1 && !visited[h][v+1]){
            visited[h][v+1] = true;
            rel = backtracking(h, v+1, index+1);
            visited[h][v+1] = false;
        }
        if(rel) return true;

        if(h < board.length-1 && !visited[h+1][v]){
            visited[h+1][v] = true;
            rel = backtracking(h+1, v, index+1);
            visited[h+1][v] = false;
        }
        return rel;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        char[][] board = {
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        String word = "SEE";
        Assert.assertEquals(true,sol.exist(board,word));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        char[][] board = {
                {'A'}
        };
        String word = "A";
        Assert.assertEquals(true,sol.exist(board,word));
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        char[][] board = {
                {'A','A'}
        };
        String word = "AAA";
        Assert.assertEquals(false,sol.exist(board,word));
    }

    @Test
    public void test4(){
        Solution sol = new Solution();
        char[][] board = {
                {'a','b'}
        };
        String word = "ba";
        Assert.assertEquals(true,sol.exist(board,word));
    }
}
