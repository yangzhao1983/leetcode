package zy.leetcode.backtracking.solution37;

import org.junit.Test;

import java.util.*;

public class Solution {
    private HashMap<Integer,Integer>[] vMaps = new HashMap[N];
    private HashMap<Integer,Integer>[] hMaps = new HashMap[N];
    private HashMap<Integer,Integer>[] cMaps = new HashMap[N];
    private final static int N = 9;

    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        // for each row, col, child group, mark if a number (1-9) has been filled.
        markNumber();

        // back tracking
        backtrack(0,0);
    }

    /**
     * if cur point is empty
     *  loop 1-9: if cur point can be filled
     *      fill it,
     *      update status
     *      fill next
     *          if it return true, return true
     *          else reset cur point, recovery status, return false
     *   if can not be filled with 1-9, return false
     * else fill next
     *
     * @param row
     * @param col
     * @return
     */
    private boolean backtrack(int row, int col){
        if(board[row][col] == '.'){
            for(int i = 0; i < 9; i++){
                if(canBeFilled(row, col, i)){
                    board[row][col] = (char)('1' + i);
                    updateStatus(row, col, i);
                    boolean rel = fillNext(row, col);
                    if(!rel){
                        board[row][col] = '.';
                        recoveryStatus(row, col, i);
                    }else{
                        return true;
                    }
                }
            }
            return false;
        }else{
            return fillNext(row, col);
        }
    }

    /**
     * find the first next non-empty point
     * if can not find
     *  return true
     * else
     *  back track it
     *  return rel of back track
     *
     * @param row
     * @param col
     * @return
     */
    private boolean fillNext(int row, int col){
        if(row == N-1 && col == N -1 ){
            return true;
        }

        if(board[row][col] == '.'){
            return backtrack(row,col);
        }else{
            // for next point
            int nextRow = col == N-1 ? row + 1 : row;
            int nextCol = col == N-1 ? 0  : col+1;
            return backtrack(nextRow, nextCol);
        }
    }

    private void updateStatus(int row, int col, int val){
        vMaps[col].put(val, 1);
        hMaps[row].put(val, 1);
        int cGroup = row/3 * 3 + col/3;
        cMaps[cGroup].put(val, 1);
    }

    private void recoveryStatus(int row, int col, int val){
        vMaps[col].put(val, 0);
        hMaps[row].put(val, 0);
        int cGroup = row/3 * 3 + col/3;
        cMaps[cGroup].put(val, 0);
    }

    private boolean canBeFilled(int row, int col, int val){
        return vMaps[col].getOrDefault(val,0 ) == 0
                && hMaps[row].getOrDefault(val, 0) == 0
                && cMaps[row/3 * 3 + col/3].getOrDefault(val, 0)==0;
    }

    private void markNumber(){
        for(int i = 0; i<vMaps.length; i++){
            vMaps[i] = new HashMap<>();
        }

        for(int i = 0; i<hMaps.length; i++){
            hMaps[i] = new HashMap<>();
        }

        for(int i = 0; i<cMaps.length; i++){
            cMaps[i] = new HashMap<>();
        }

        for(int i = 0; i<N;i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] != '.'){
                    updateStatus(i, j, board[i][j] - '1');
                }
            }
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        sol.solveSudoku(board);
    }
}
