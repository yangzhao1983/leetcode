package zy.leetcode.mysort.solution164;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length <=1){
            return 0;
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int n = nums.length;

        int bucketSize = Math.max(1, (max - min)/(n-1));
        int bucketCnt = (max - min)/bucketSize + 1;

        boolean[] used = new boolean[bucketCnt];
        int[] bucketMin = new int[bucketCnt];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        int[] bucketMax = new int[bucketCnt];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for(int num : nums){
            int index = (num - min)/bucketSize;
            used[index] = true;
            bucketMin[index] = Math.min(num, bucketMin[index]);
            bucketMax[index] = Math.max(num, bucketMax[index]);
        }

        int preMax = min;
        int maxGap = 0;

        for(int i = 0; i < bucketCnt; i++){
            if(!used[i]) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - preMax);
            preMax = bucketMax[i];
        }

        return maxGap;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {3,6,9,1};
        Assert.assertEquals(3, sol.maximumGap(nums));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        int[] nums = {1,10000000};
        Assert.assertEquals(9999999, sol.maximumGap(nums));
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        int[] nums = {1,4, 7, 10};
        Assert.assertEquals(3, sol.maximumGap(nums));
    }
}
