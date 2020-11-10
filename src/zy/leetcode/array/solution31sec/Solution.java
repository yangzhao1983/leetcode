package zy.leetcode.array.solution31sec;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    /**
     * i<j
     * k>=i, k<=j
     *
     * k<j
     * a[k] < a[k+1]
     * k+1 = j or a[k+1]>a[k+2]..>a[j]
     * swap a[k] and Min(a[m], k<m<=j, a[m]>a[k])
     *
     * or
     * a[k] >= a[k+1]
     *
     * sort
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int n = nums.length;
        int i = nums.length - 2;
        while(i >=0){
            if(nums[i] >= nums[i+1])i--;
            else break;
        }
        if(i>=0){
            int max = Integer.MAX_VALUE;
            int maxPos = n-1;
            for(int j = i+1; j<n; j++){
                if(nums[j] > nums[i]){
                    if(nums[j] < max) maxPos = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[maxPos];
            nums[maxPos] = tmp;
        }
        Arrays.sort(nums, i+1,n);
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {3,2,1};
        sol.nextPermutation(nums);
        System.out.println();
    }
}
