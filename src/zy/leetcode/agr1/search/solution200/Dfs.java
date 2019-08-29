package zy.leetcode.agr1.search.solution200;

/**
 * Created by kaiser_zhao on 2019/8/28.
 */
public class Dfs {

    public static void main(String...strings){
//        testcase1();
//        testcase3();
        testcase2();
    }

    private static void testcase1(){
        char[][] input = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(input));
    }

    private static void testcase2(){
        char[][] input = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(input));
    }

    private static void testcase3(){
        char[][] input = {{'1','0','1','1','0','1','1'}};
        System.out.println(numIslands(input));
    }

    private static int count = 0;

    public static int numIslands(char[][] grid) {
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j < grid[i].length; j++){
                // if grid[i][j] == 1, count++ dps
                // else next
                if(grid[i][j] == '1'){
                    count++;
                    dps(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void dps(char[][] grid, int dim1, int dim2){
        // if char[hor][ver] == 0, return
        // if char[hor][ver]== 1, set it to 0, for every connected nodes of it, dps
        // hor - 1, hor+1, ver+1, ver-1,
        if(dim2<0 || dim2 >= grid[0].length || dim1 < 0 || dim1 >= grid.length){
            return;
        }

        if(grid[dim1][dim2] == '0'){
            return;
        }else{
            grid[dim1][dim2] = '0';
            dps(grid, dim1 -1 , dim2);
            dps(grid, dim1 , dim2 -1 );
            dps(grid, dim1 +1 , dim2);
            dps(grid, dim1 , dim2+1);
        }
    }
}
