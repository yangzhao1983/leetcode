package zy.leetcode.graph.solution1162;

import zy.leetcode.linked.ListNode;
import zy.leetcode.queue.solution239.QueueSlideWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public int maxDistance(int[][] grid) {
        Deque<List<Integer>> points = new ArrayDeque<>();
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[i].length;j++){
                if(grid[i][j]==1){
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    points.addLast(point);
                }
            }
        }
        int max = 0;
        while(!points.isEmpty()){
            List<Integer> point = points.pollFirst();

            max = grid[point.get(0)][point.get(1)];

            int curH = point.get(0);
            int curV = point.get(1);

            // top
            if(curH > 0 && grid[curH-1][curV]==0){
                grid[curH-1][curV]=max + 1;
                List<Integer> list = new ArrayList<>();
                list.add(curH -1);
                list.add(curV);
                points.add(list);
            }
            // down
            if(curH < grid.length-1 && grid[curH+1][curV]==0){
                grid[curH+1][curV]=max + 1;
                List<Integer> list = new ArrayList<>();
                list.add(curH +1);
                list.add(curV);
                points.add(list);
            }

            // left
            if(point.get(1) >0 && grid[curH][curV-1]==0){
                grid[curH][curV-1]=max + 1;
                List<Integer> list = new ArrayList<>();
                list.add(curH);
                list.add(curV-1);
                points.add(list);
            }

            // right
            if(curV < grid.length-1 && grid[curH][curV+1]==0){
                grid[curH][curV+1]=max + 1;
                List<Integer> list = new ArrayList<>();
                list.add(curH);
                list.add(curV+1);
                points.add(list);
            }
        }
        return max==1?-1:max-1;
    }

    private static void test1(){
        int[][] grid = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        Solution sol = new Solution();
        System.out.println(sol.maxDistance(grid));
    }

    private static void test2(){
        int[][] grid = new int[][]{{1,0,0},{0,0,0},{0,0,0}};
        Solution sol = new Solution();
        System.out.println(sol.maxDistance(grid));
    }

    public static void main(String...strings){
        test1();
        test2();
    }
}
