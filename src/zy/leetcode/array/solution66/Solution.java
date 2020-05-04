package zy.leetcode.array.solution66;

import org.junit.Test;

public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] ans = digits;
        while(n >0){
            int sum = digits[n-1] + 1;
            if(sum < 10){
                digits[n-1] = sum;
                return ans;
            }else{
                digits[n-1] = 0;
                n--;
            }
        }
        ans = new int[digits.length+1];
        ans[0] = 1;
        return ans;
    }

    @Test
    public void test(){
        int[] digits = {0};
        Solution sol = new Solution();
        int[] ans = sol.plusOne(digits);
        System.out.println();
    }

    @Test
    public void test2(){
        int[] digits = {9};
        Solution sol = new Solution();
        int[] ans = sol.plusOne(digits);
        System.out.println();
    }
}
