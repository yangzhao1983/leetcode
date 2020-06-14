package zy.leetcode.sortandsearch.solution1300;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        int n = arr.length;
        int[] preSum = new int[n + 1];
        for(int i= 1; i < n; i++){
            preSum[i] = preSum[i-1] + arr[i-1];
        }

        int ans = 0;
        int diff = target;
        for(int i = 0; i <= arr[n-1]; i++){
            int index = Arrays.binarySearch(arr, i);
            if(index < 0){
                index = -index - 1;
            }
            int newDiff = Math.abs(preSum[index] + i * (n - index) - target);
            if (newDiff < diff){
                diff = newDiff;
                ans = i;
            }
        }

        return ans;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(3, sol.findBestValue(new int[]{4,9,3}, 10));
    }
}
