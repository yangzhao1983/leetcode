package zy.leetcode.heap.solution973;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return getProduct(o1) - getProduct(o2);
            }

            private int getProduct(Pair<Integer, Integer> p){
                return p.getKey() * p.getKey() + p.getValue() * p.getValue();
            }
        });

        for(int[] point : points){
            pq.add(new Pair<>(point[0], point[1]));
        }
        int[][] ans = new int[K][2];

        for(int i = 0; i < ans.length;i++){
            Pair<Integer, Integer> p = pq.poll();
            ans[i][0] = p.getKey();
            ans[i][1] = p.getValue();
        }
        return ans;
    }
}
