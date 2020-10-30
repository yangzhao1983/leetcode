package zy.leetcode.graph.solution1034;

import org.junit.Test;

public class Solution {
    private boolean[][] colored;
    private int base;
    private int color;

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return grid;
        colored = new boolean[grid.length][grid[0].length];
        base = grid[r0][c0];
        doColor(grid, r0, c0, color);
        return grid;
    }

    private boolean isBorder(int[][] grid, int r, int c) {
        if (r == 0 || r == grid.length-1 || c == 0 || c == grid[0].length-1) {
            return true;
        }

        // top
        if(r>0 && grid[r-1][c] != base && !colored[r-1][c]){
            return true;
        }

        // bottom
        if(r<grid.length-1 && grid[r+1][c] != base && !colored[r+1][c]){
            return true;
        }

        // left
        if(c >0 && grid[r][c-1] != base && !colored[r][c-1]){
            return true;
        }

        // right
        if(c<grid[0].length-1 && grid[r][c+1] != base && !colored[r][c+1]){
            return true;
        }

        return false;
    }

    private void doColor(int[][] grid, int r, int c, int color) {
        if (grid[r][c] != base) {
            return;
        }
        if (colored[r][c]) {
            return;
        }
        colored[r][c] = true;
        if (isBorder(grid, r, c)) grid[r][c] = color;

        // top
        if (r > 0) {
            doColor(grid, r - 1, c, color);
        }

        // bottom
        if (r < grid.length - 1) {
            doColor(grid, r + 1, c, color);
        }

        // left
        if (c > 0) {
            doColor(grid, r, c - 1, color);
        }

        // right
        if (c < grid[0].length - 1) {
            doColor(grid, r, c + 1, color);
        }
    }

    @Test
    public void test(){
        int[][] grid = {{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}};
        Solution sol = new Solution();
        int[][] ans = sol.colorBorder(grid, 1,3,1);
        System.out.println();
    }
}
