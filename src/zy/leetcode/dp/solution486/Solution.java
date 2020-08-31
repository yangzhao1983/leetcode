package zy.leetcode.dp.solution486;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    // sum(l, r)
    // max(l, r)
    // choose l: max(sum(l, r) - max(l+1, r))
    // choose r: max(sum(l, r) - max(l, r-1))
    private int[][] sum;
    private int[] nums;
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        sum = new int[n][n];
        this.nums = nums;

        for(int step = 0; step < n; step++){
            for(int i = 0; i < n-step;i++){
                if(step==0) sum[i][i+step] = nums[i];
                else sum[i][i+step] = sum[i][i+step-1] + nums[i+step];
            }
        }
        int first =  calScore(nums, 0, n-1);
        int second = sum[0][n-1] - first;
        return first >= second;
    }

    private int calScore(int[] nums, int l, int r){
        if(l == r) return nums[l];
        return Math.max(sum[l][r] - calScore(nums, l+1, r), sum[l][r] - calScore(nums, l, r-1));
    }

    @Test
    public void test1(){
        int[] nums = {1, 5, 2};
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.PredictTheWinner(nums));
    }

    @Test
    public void test2(){
        int[] nums = {1, 5, 233, 7};
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.PredictTheWinner(nums));
    }
}
