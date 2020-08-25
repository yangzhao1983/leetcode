package zy.leetcode.tree.solution529;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    private char[][] board;
    private int m;
    private int n;

    public char[][] updateBoard(char[][] board, int[] click) {

        this.board = board;
        m = board.length;
        n = board[0].length;

        int sr = click[0];
        int sc = click[1];
        if(board[sr][sc]=='M'){
            board[sr][sc] = 'X';
        }else{
            doUpdateBoard(sr, sc);
        }

        return board;
    }

    private void doUpdateBoard(int sr, int sc){
        if(sr <0 || sc <0 || sr == m || sc==n){
            return;
        }
        char val = board[sr][sc];

        // if revealed, return
        if((val >= '1' && val <='8') || val =='M' || val=='B') return;

        Pair<Integer, List<Pair<Integer, Integer>>> rel = calculateSurrounding(sr, sc);
        if( rel.getKey()==0){
            board[sr][sc] = 'B';
            for(Pair<Integer, Integer> pair : rel.getValue()){
                doUpdateBoard(pair.getKey(), pair.getValue());
            }
        } else{
            board[sr][sc] = (char)('0' + rel.getKey());
        }
    }

    private Pair<Integer,List<Pair<Integer, Integer>>> calculateSurrounding(int sr, int sc){
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        // count of mines
        int cnt = 0;
        // top
        if(sr>0) {
            if(board[sr-1][sc]!='M')list.add(new Pair<>(sr-1, sc));
            else cnt++;
        }

        // bottom
        if(sr < m-1) {
            if(board[sr+1][sc] != 'M')list.add(new Pair<>(sr+1, sc));
            else cnt++;
        }

        // left
        if(sc>0) {
            if(board[sr][sc-1]!='M')list.add(new Pair<>(sr, sc-1));
            else cnt++;
        }

        // right
        if(sc<n-1) {
            if(board[sr][sc+1]!='M')list.add(new Pair<>(sr, sc+1));
            else cnt++;
        }

        // top-left
        if(sr > 0 && sc >0) {
            if(board[sr-1][sc-1] != 'M')list.add(new Pair<>(sr-1, sc-1));
            else cnt++;
        }

        // top-right
        if(sr > 0 && sc < n-1) {
            if(board[sr-1][sc+1] != 'M')list.add(new Pair<>(sr-1, sc+1));
            else cnt++;
        }

        // bottom-left
        if(sr < m-1 && sc > 0) {
            if(board[sr+1][sc-1] != 'M')list.add(new Pair<>(sr+1, sc-1));
            else cnt++;
        }

        // bottom-right
        if(sr < m-1 && sc < n-1) {
            if(board[sr+1][sc+1] != 'M')list.add(new Pair<>(sr+1, sc+1));
            else cnt++;
        }

        return new Pair<>(cnt, list);
    }
}
