package zy.leetcode.array.solution289;

import org.junit.Assert;
import org.junit.Test;
public class Solution {
    /**
     * 2: 0->1
     * 3: 1->0
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                int count = 0;
                // top
                if(i > 0 && (board[i-1][j]==1 || board[i-1][j] == 3)){
                    count ++;
                }
                // down
                if(i < board.length-1 && (board[i+1][j]==1 || board[i+1][j] == 3)){
                    count ++;
                }

                // left
                if(j > 0 && (board[i][j-1]==1 || board[i][j-1] == 3)){
                    count ++;
                }

                // right
                if(j < board[i].length -1 && (board[i][j+1]==1 || board[i][j+1] == 3)){
                    count ++;
                }

                // left top
                if(i > 0 && j> 0 && (board[i-1][j-1]==1 || board[i-1][j-1] == 3)){
                    count ++;
                }

                // right top
                if(i >0  && j<board[i].length -1 && (board[i-1][j+1]==1 || board[i-1][j+1] == 3)){
                    count ++;
                }

                // left down
                if(i < board.length -1  && j > 0 && (board[i+1][j-1]==1 || board[i+1][j-1] == 3)){
                    count ++;
                }

                // right down
                if(i < board.length -1  && j < board[i].length -1 && (board[i+1][j+1]==1 || board[i+1][j+1] == 3)){
                    count ++;
                }
                if(count < 2){
                    if(board[i][j]==1){
                        board[i][j]=3;
                    }
                }else if(count == 3){
                    if(board[i][j]==0){
                        board[i][j]=2;
                    }
                }else if(count >= 3){
                    if(board[i][j]==1){
                        board[i][j]=3;
                    }
                }
            }
        }
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }

    @Test
    public void test1(){
        int[][] board = new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0},
        };
        Solution sol = new Solution();

        sol.gameOfLife(board);
        Assert.assertArrayEquals(new int[]{0,0,0}, board[0]);
        Assert.assertArrayEquals(new int[]{1,0,1}, board[1]);
        Assert.assertArrayEquals(new int[]{0,1,1}, board[2]);
        Assert.assertArrayEquals(new int[]{0,1,0}, board[3]);
    }
}
