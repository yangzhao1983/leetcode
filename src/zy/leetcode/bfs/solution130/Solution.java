package zy.leetcode.bfs.solution130;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * start from 'O' cells locating on the edge
     *
     *
     * @param board
     */
    public void solve(char[][] board) {
        if(board==null || board.length ==0 || board[0]==null || board[0].length==0) return;
        this.board = board;
        for(int i = 0; i< board.length; i++){
            doBFS(i, 0);
        }

        for(int j = 1; j< board[0].length; j++){
            doBFS(board.length-1, j);
        }

        for(int i = board.length-2; i>=0; i--){
            doBFS(i, board[0].length-1);
        }

        for(int j = board[0].length-2; j>0; j--){
            doBFS(0, j);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = board[i][j]=='V'? 'O': 'X';
            }
        }
    }

    private char[][] board = null;

    private void doBFS(int row, int col){
        if(board[row][col] == 'O'){
            Queue<Pair<Integer, Integer>> q = new LinkedList<>();
            Pair<Integer, Integer> first = new Pair<>(row, col);
            q.add(first);
            while(!q.isEmpty()){
                Pair<Integer, Integer> now = q.poll();
                int nowRow = now.getKey();
                int nowCol = now.getValue();
                if(board[nowRow][nowCol] == 'X' || board[nowRow][nowCol] == 'V') continue;
                board[nowRow][nowCol] = 'V';
                // top
                if(nowRow>0 && board[nowRow-1][nowCol]=='O') q.add(new Pair<>(nowRow-1, nowCol));

                // bottom
                if(nowRow<board.length-1 && board[nowRow+1][nowCol]=='O') q.add(new Pair<>(nowRow+1, nowCol));


                // left
                if(nowCol>0 && board[nowRow][nowCol-1]=='O') q.add(new Pair<>(nowRow, nowCol-1));


                // right
                if(nowCol<board[0].length-1 && board[nowRow][nowCol+1]=='O') q.add(new Pair<>(nowRow, nowCol+1));
            }
        }
    }
}
