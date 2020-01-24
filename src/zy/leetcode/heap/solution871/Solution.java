package zy.leetcode.heap.solution871;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int minRefuelStops(int target, int tank, int[][] stations) {
        // pq is a maxheap of gas station capacities
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int ans = 0, prev = 0;
        for (int[] station: stations) {
            int location = station[0];
            int capacity = station[1];
            tank -= location - prev;
            while (!pq.isEmpty() && tank < 0) {  // must refuel in past
                tank += pq.poll();
                ans++;
            }

            if (tank < 0) return -1;
            pq.offer(capacity);
            prev = location;
        }

        // Repeat body for station = (target, inf)
        {
            tank -= target - prev;
            while (!pq.isEmpty() && tank < 0) {
                tank += pq.poll();
                ans++;
            }
            if (tank < 0) return -1;
        }

        return ans;
    }

    public static void test1(){
        int target = 100;
        int startFuel = 10;
        int[][] stations = {{10,60},{20,30},{30,30}};
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(target, startFuel, stations));
    }

    public static void test2(){
        int target = 1;
        int startFuel = 1;
        int[][] stations = {};
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(target, startFuel, stations));
    }

    public static void test3(){
        int target = 100;
        int startFuel = 1;
        int[][] stations = {{10,100}};
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(target, startFuel, stations));
    }

    public static void test4(){
        int target = 100;
        int startFuel = 50;
        int[][] stations = {{40,50}};
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(target, startFuel, stations));
    }

    public static void test5(){
        int target = 100;
        int startFuel = 50;
        int[][] stations = {{25,25},{50,50}};
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(target, startFuel, stations));
    }

    public static void test6(){

        int target = 200;
        int startFuel = 50;
        int[][] stations = {{25,25},{50,100},{100,100},{150,40}};
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(target, startFuel, stations));
    }

    public static void test7(){

        int target = 1000;
        int startFuel = 299;
        int[][] stations = {{13,21},{26,115},
                {100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}};
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(target, startFuel, stations));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
}
