package zy.leetcode.math.solution62;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            nums.add(i);
        }

        int start = 0;

        for(int i = 0; i < n-1; i++){
            start = (start + m - 1)%nums.size();
            nums.remove(start);
        }

        return nums.get(0);
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        System.out.println(sol.lastRemaining(5,3));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        System.out.println(sol.lastRemaining(10,17));
    }
}
