package zy.leetcode.heap.solution378;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] indices = new int[matrix.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return matrix[o1][indices[o1]] - matrix[o2][indices[o2]];
            }
        });

        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            pq.add(i);
        }
        int row = 0;
        while (cnt < k) {
            row = pq.poll();
            indices[row]++;
            if(indices[row] < matrix.length) pq.add(row);
            cnt++;
        }
        return matrix[row][indices[row] - 1];
    }

    @Test
    public void test1() {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        Solution sol = new Solution();
        Assert.assertEquals(13, sol.kthSmallest(matrix, k));
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1}
        };
        int k = 1;
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.kthSmallest(matrix, k));
    }
}
