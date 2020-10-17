package zy.leetcode.backtracking.solution52sec;

public class Solution {
    private int cnt = 0;
    private int[][] p;
    private int n = 0;
    public int totalNQueens(int n) {
        if(n==0) return 0;
        this.p = new int[n][n];
        this.n = n;
        doBackTracking(0);
        return cnt;
    }

    private void doBackTracking(int cur){
        if(cur==n) {
            cnt++;
            return;
        }
        for(int i = 0; i <n ; i++){
            if(p[cur][i] == 0){
                p[cur][i]++;
                update(cur, i, false);
                doBackTracking(cur+1);
                update(cur, i, true);
                p[cur][i] = 0;
            }
        }
    }
    private void update(int row, int col, boolean rollback){
        int curRow = row;
        int curCol = col;
        int diff = rollback ? -1 : 1;

        // top
        while(--curRow >=0){
            p[curRow][col] += diff;
        }

        curRow = row;
        // bottom
        while(++curRow < n){
            p[curRow][col] += diff;
        }

        // left
        while(--curCol >=0){
            p[row][curCol] += diff;
        }

        // right
        curCol = col;
        while(++curCol <n){
            p[row][curCol] += diff;
        }

        // top-left
        curRow = row;
        curCol = col;
        while(--curRow>= 0 && --curCol >=0){
            p[curRow][curCol] += diff;
        }

        // top-right
        curRow = row;
        curCol = col;
        while(--curRow>=0 && ++curCol <n){
            p[curRow][curCol] += diff;
        }

        // bottom-left
        curRow = row;
        curCol = col;
        while(++curRow<n && --curCol >=0){
            p[curRow][curCol] += diff;
        }

        // bottom-right
        curRow = row;
        curCol = col;
        while(++curRow< n && ++curCol <n){
            p[curRow][curCol] += diff;
        }
    }
}
