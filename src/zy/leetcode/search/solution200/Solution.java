package zy.leetcode.search.solution200;

public class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i< grid.length; i++){
            for(int j =0; j<grid[i].length; j++){
                char startPoint = grid[i][j];
                if(startPoint == 'a' || startPoint == '0'){
                    continue;
                }else{
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int startFirst, int startSecond){
        if(startFirst <0 || startFirst >= grid.length || startSecond <0 || startSecond >= grid[startFirst].length){
            return;
        }

        char startPoint = grid[startFirst][startSecond];

        // sea or visited
        if(startPoint == 'a' || startPoint == '0'){
            return;
        }

        // visited
        grid[startFirst][startSecond] = 'a';

        dfs(grid, startFirst -1, startSecond );
        dfs(grid, startFirst +1, startSecond);
        dfs(grid, startFirst, startSecond-1 );
        dfs(grid, startFirst, startSecond+1);
    }

    private static void test1(){
        char[][] matrix = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        Solution solution = new Solution();
        System.out.println(solution.numIslands(matrix));
    }

    public static void main(String...strings){
        test1();
    }
}
