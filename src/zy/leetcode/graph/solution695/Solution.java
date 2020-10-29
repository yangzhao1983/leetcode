package zy.leetcode.graph.solution695;

public class Solution {
    private boolean[][] visited;
    private int m, n;
    private int curArea;
    private int ans;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length == 0 || grid[0].length==0) return 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j <n; j++){
                curArea = 0;
                doDFS(grid, i, j);
                ans = Math.max(ans, curArea);
            }
        }
        return ans;
    }

    private void doDFS(int[][] grid, int r, int c){

        if(grid[r][c]==0){
            return;
        }

        if(visited[r][c]){
            return;
        }else{
            visited[r][c] = true;
        }

        curArea++;

        // top
        if(r>0){
            doDFS(grid, r-1, c);
        }
        // bottom
        if(r<m-1){
            doDFS(grid, r+1, c);
        }

        // left
        if(c>0){
            doDFS(grid, r, c-1);
        }

        // right
        if(c<n-1){
            doDFS(grid, r, c+1);
        }
    }
}
