package zy.leetcode.heap.solution215;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int item : nums){
            pq.add(item);
        }
        for(int i = 0; i < k-1; i++){
            pq.poll();
        }
        return pq.poll();
    }

    @Test
    public void test1(){
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        Solution sol = new Solution();
        Assert.assertEquals(5, sol.findKthLargest(nums, k));
    }
}
