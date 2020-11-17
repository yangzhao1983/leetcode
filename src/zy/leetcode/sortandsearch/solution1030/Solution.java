package zy.leetcode.sortandsearch.solution1030;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<List<int[]>> bucket = new ArrayList<>();
        int max = Math.max(R - r0, r0) +  Math.max(C - c0, c0);
        for(int i = 0; i <= max; i++){
            bucket.add(new ArrayList<>());
        }
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                int dist = calDist(i, r0, j, c0);
                bucket.get(dist).add(new int[]{i, j});
            }
        }
        int[][] ans = new int[R*C][];
        int i = 0;
        for(List<int[]> list : bucket){
            for(int[] cell : list){
                ans[i] = cell;
                i++;
            }
        }
        return ans;
    }

    private int calDist(int sr, int er,int sc, int ec){
        return Math.abs(ec - sc) + Math.abs(er - sr);
    }
}
