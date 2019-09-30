package zy.leetcode.graph.solution329;

/**
 * Created by kaiser_zhao on 2019/9/30.
 */
public class SolByDSF {

    public static void main(String...strings){
//        testcase1();
        testcase2();
    }

    private static void testcase1(){
        int[] nums1 = {9,9,4};
        int[] nums2 = {6,6,8};
        int[] nums3 = {2,1,1};
        int[][] nums = {nums1, nums2, nums3};
        System.out.println(longestIncreasingPath(nums));
    }

    private static void testcase2(){
        int[] nums1 = {3,4,5};
        int[] nums2 = {3,2,6};
        int[] nums3 = {2,2,1};
        int[][] nums = {nums1, nums2, nums3};
        System.out.println(longestIncreasingPath(nums));
    }

    private static int[][] pathLen = null;

    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length == 0){
            return 0;
        }
        if(matrix.length == 1 && (matrix[0]==null || matrix[0].length == 0)){
            return 0;
        }

        pathLen = new int[matrix.length][matrix[0].length];

        // initialize pathLen -1
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                pathLen[i][j] = -1;
            }
        }

        int maxPath = -1;

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int path = doDSF(i, j, matrix);
                pathLen[i][j] = path;
                if(path > maxPath){
                    maxPath = path;
                }
            }
        }

        return maxPath;
    }

    private static int doDSF(int i, int j, int[][] matrix){
        // visited
        if(pathLen[i][j] >= 1){
            return pathLen[i][j];
        }

        int maxPath = 1;
        int path = 0;
        // if next node is accessible
        // up
        if(nextAccessible(i-1, j, matrix, matrix[i][j])){
            maxPath = doDSF(i-1, j, matrix) + 1;
        }

        // down
        if(nextAccessible(i+1, j, matrix, matrix[i][j])){
            path = doDSF(i+1, j, matrix) + 1;
            if(path > maxPath){
                maxPath = path;
            }
        }

        // left
        if(nextAccessible(i, j-1, matrix, matrix[i][j])){
            path = doDSF(i, j-1, matrix) + 1;
            if(path > maxPath){
                maxPath = path;
            }
        }

        // right
        if(nextAccessible(i, j+1, matrix, matrix[i][j])){
            path = doDSF(i, j+1, matrix) + 1;
            if(path > maxPath){
                maxPath = path;
            }
        }

        pathLen[i][j] = maxPath;

        return maxPath;
    }

    private static boolean nextAccessible(int i, int j, int[][] matrix, int curVal){
        if(i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length
        && curVal < matrix[i][j]){
           return true;
        }else{
            return false;
        }
    }
}
