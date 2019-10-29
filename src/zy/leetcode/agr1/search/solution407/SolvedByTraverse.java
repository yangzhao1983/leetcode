package zy.leetcode.agr1.search.solution407;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kaiser_zhao on 2019/9/17.
 */
public class SolvedByTraverse {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null ||heightMap.length <=2 || heightMap[0].length<=2){
            return 0;
        }

        alivePoints = new int[heightMap.length][heightMap[0].length];
        for(int i = 1; i < heightMap.length -1; i++ ){
            for(int j = 0; j<heightMap[0].length-1; j++){
                alivePoints[i][j] = 1;
            }
        }

        traverse(heightMap);
        return  count;
    }

    private static int count = 0;

    private static int[][] alivePoints;

    private static LinkedList<List<Integer>> indicesForMinimum = new LinkedList<>();

    private static void findIndicesForMinimum(int[][] heightMap){
        int minimum = Integer.MAX_VALUE;
        for(int i = 0; i<heightMap.length; i++){

        }
    }

    private static void traverse(int[][] heightMap){

    }
}
