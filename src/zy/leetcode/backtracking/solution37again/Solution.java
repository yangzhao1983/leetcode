package zy.leetcode.backtracking.solution37again;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    // status:
    // 1. vertical
    private List<Set<Integer>> ver = new ArrayList<>();

    // 2. horizon
    private List<Set<Integer>> hor = new ArrayList<>();

    // 3. sub-boxes
    private List<Set<Integer>> sub = new ArrayList<>();

    private char[][] board;
    private int m;
    private int n;
    private boolean found = false;

    public void solveSudoku(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        init();
        doBacktracking(0, 0);
    }

    private void init() {
        for (int i = 0; i < 9; i++) {
            ver.add(new HashSet<>());
            hor.add(new HashSet<>());
            sub.add(new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                hor.get(i).add(board[i][j] - '0');
                ver.get(j).add(board[i][j] - '0');
                int rowSub = i / 3;
                int colSub = j / 3;
                sub.get(rowSub * 3 + colSub).add(board[i][j] - '0');
            }
        }
    }

    private boolean available(int row, int col, int num) {
        if (ver.get(col).contains(num)) return false;
        if (hor.get(row).contains(num)) return false;
        int rowSub = row / 3;
        int colSub = col / 3;
        if (sub.get(rowSub * 3 + colSub).contains(num)) return false;

        return true;
    }

    private void updateStatus(int row, int col, int num, boolean rollback) {
        int rowSub = row / 3;
        int colSub = col / 3;
        if (rollback) {
            ver.get(col).remove(num);
            hor.get(row).remove(num);
            sub.get(rowSub * 3 + colSub).remove(num);
            board[row][col] = '.';
        } else {
            ver.get(col).add(num);
            hor.get(row).add(num);
            sub.get(rowSub * 3 + colSub).add(num);
            board[row][col] =(char)('0' + num);
        }
    }

    private void doBacktracking(int row, int col) {
        // for each cell, get the available candidates
        // set the number for the cell, update status
        // move to next cell
        // roll back status
        if (found) return;
        if (row == m) {
            found = true;
            return;
        }

        if (board[row][col] != '.') {
            int[] next = goToNext(row, col);
            doBacktracking(next[0], next[1]);
        } else {
            for (char i = 1; i <= 9; i++) {
                if (available(row, col, i)) {
                    updateStatus(row, col, i, false);
                    int[] next = goToNext(row, col);
                    doBacktracking(next[0], next[1]);
                    if (found) return;
                    updateStatus(row, col, i, true);
                }
            }
        }
    }

    private int[] goToNext(int row, int col) {
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == this.n) {
            nextCol = 0;
            nextRow = row + 1;
        }

        if (nextRow < m && board[nextRow][nextCol] != '.') {
            return goToNext(nextRow, nextCol);
        } else {
            return new int[]{nextRow, nextCol};
        }
    }

    @Test
    public void test1() {
        Solution sol = new Solution();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        sol.solveSudoku(board);
        Set<Character> test = new HashSet<>();
        test.add('1');
        System.out.println(test.contains('1'));
        System.out.println(test.contains(49));
    }

}
