package zy.leetcode.hashtable.solution36;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Integer> [] vMaps = new HashMap[9];
        HashMap<Integer,Integer> [] hMaps = new HashMap[9];
        HashMap<Integer,Integer> [] cMaps = new HashMap[9];

        for(int i = 0; i<9; i++){
            vMaps[i] = new HashMap<>();
            hMaps[i] = new HashMap<>();
            cMaps[i] = new HashMap<>();
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if('.' == board[i][j]){
                    continue;
                }

                if(vMaps[i].containsKey(board[i][j]-'1')){
                    return false;
                }else{
                    vMaps[i].put(board[i][j] - '1', 1);
                }

                if(hMaps[j].containsKey(board[i][j]-'1')){
                    return false;
                }else{
                    hMaps[j].put(board[i][j] - '1', 1);
                }

                int childGroup = i/3 * 3 + j/3;

                if(cMaps[childGroup].containsKey(board[i][j]-'1')){
                    return false;
                }else{
                    cMaps[childGroup].put(board[i][j] - '1', 1);
                }
            }
        }

        return true;
    }

    //@Test
    public void test1(){
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
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isValidSudoku(board));
    }

    @Test
    public void test2(){
        char[][] board = new char[][]{

                    {'.','8','7','6','5','4','3','2','1'},
                        {'2','.','.','.','.','.','.','.','.'},
                        {'3','.','.','.','.','.','.','.','.'},
                        {'4','.','.','.','.','.','.','.','.'},
                        {'5','.','.','.','.','.','.','.','.'},
                        {'6','.','.','.','.','.','.','.','.'},
                        {'7','.','.','.','.','.','.','.','.'},
                        {'8','.','.','.','.','.','.','.','.'},
                        {'9','.','.','.','.','.','.','.','.'}

        };
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isValidSudoku(board));
    }
}
