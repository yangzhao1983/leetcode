package zy.leetcode.hash.solution149;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private int[][] points;

    // slope, list of point indices
    private Map<String, List<Integer>> pointsInLine = new HashMap<>();

    public int maxPoints(int[][] points) {
        this.points = points;
        if(points==null || points.length==0) return 0;
        else if (points.length <=2) return points.length;
        else return calCountOfPoints();
    }

    /**
     * For each point, calculate the max number of points in the line starting from it.
     *
     * @return
     */
    private int calCountOfPoints(){
        int max = 0;
        for(int i = 0; i < points.length-1; i++){
            // calculate the max number of points contained by the line starting from current point
            int cur = calCountOFPointsForGivenPoint(i);
            max = Math.max(cur, max);
        }
        return max;
    }

    /**
     * @param start
     * @return
     */
    private int calCountOFPointsForGivenPoint(int start){
        pointsInLine.clear();
        int duplicated = 0;
        int parallel = 1;
        int cnt = 0;

        int x1 = points[start][0];
        int y1 = points[start][1];

        for(int i = start+1; i<points.length;i++){
            int x2 = points[i][0];
            int y2 = points[i][1];

            // duplicated
            if(x1 == x2 && y1 == y2){
                duplicated++;
            }else if(y1 == y2){
                // parallel
                parallel++;
            }else{
                // slope
                String curSlope = calSlope(x1, x2, y1, y2);
                pointsInLine.computeIfAbsent(curSlope, x->new ArrayList<>()).add(i);
                cnt = Math.max(pointsInLine.get(curSlope).size(), cnt);
            }
        }
        return Math.max(parallel, cnt+1) + duplicated;
    }

    private String calSlope(int x1, int x2, int y1, int y2){
        int numerator = x1 - x2;
        int denominator = y1 - y2;
        return doReduction(numerator, denominator);
    }

    private String doReduction(int first, int second){
        int fT = first;
        int sT = second;
        int remainder = 1;
        while(remainder!=0){
            remainder = fT % sT;
            fT = sT;
            sT = remainder;
        }
        int gcd = fT;
        return Integer.toString(first/gcd) + "_" + Integer.toString(second/gcd);
    }

    @Test
    public void test1(){
        int[][] points = {{1,1},{2,2},{3,3}};
        Solution sol = new Solution();
        Assert.assertEquals(3, sol.maxPoints(points));
    }

    @Test
    public void test2(){
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        Solution sol = new Solution();
        Assert.assertEquals(4, sol.maxPoints(points));
    }

    @Test
    public void test3(){
        int[][] points = {{-4,1},{-7,7},{-1,5},{9,-25}};
        Solution sol = new Solution();
        Assert.assertEquals(3, sol.maxPoints(points));
    }

    @Test
    public void test4(){
        int[][] points = {{0,0},{94911150,94911151},{94911151,94911152}};
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.maxPoints(points));
    }
}
