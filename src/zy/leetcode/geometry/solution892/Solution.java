package zy.leetcode.geometry.solution892;

public class Solution {
    public int surfaceArea(int[][] grid) {
        int ans = 0;
        for(int i = 0; i <grid.length; i++){
            for(int j = 0; j<grid.length;j++){
                // top and bottom
                if(grid[i][j]!=0){
                    ans += 2;
                }

                // up
                if(i==0){
                    ans += grid[i][j];
                }else{
                    if(grid[i-1][j] < grid[i][j]){
                        ans += grid[i][j] - grid[i-1][j];
                    }
                }

                // down
                if(i==grid.length-1){
                    ans += grid[i][j];
                }else{
                    if(grid[i+1][j] < grid[i][j]){
                        ans += grid[i][j] - grid[i+1][j];
                    }
                }

                // left
                if(j==0){
                    ans += grid[i][j];
                }else{
                    if(grid[i][j-1] < grid[i][j]){
                        ans += grid[i][j] - grid[i][j-1];
                    }
                }

                // right
                if(j==grid.length-1){
                    ans += grid[i][j];
                }else{
                    if(grid[i][j+1] < grid[i][j]){
                        ans += grid[i][j] - grid[i][j+1];
                    }
                }
            }
        }
        return ans;
    }

    private static void test1(){
        int[][] grid = new int[][]{{2,2,2},{2,1,2},{2,2,2}};
        Solution sol = new Solution();
        System.out.println(sol.surfaceArea(grid));
    }

    private static void test2(){
        int[][] grid = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        Solution sol = new Solution();
        System.out.println(sol.surfaceArea(grid));
    }

    private static void test3(){
        int[][] grid = new int[][]{{2}};
        Solution sol = new Solution();
        System.out.println(sol.surfaceArea(grid));
    }

    private static void test4(){
        int[][] grid = new int[][]{{1,2},{3,4}};
        Solution sol = new Solution();
        System.out.println(sol.surfaceArea(grid));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
    }
}
