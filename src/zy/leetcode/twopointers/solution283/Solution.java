package zy.leetcode.twopointers.solution283;

public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int start=0;
        int nonzero=0;
        int n = nums.length;
        while(start < n && nonzero <n){
            while(start < n && nums[start] != 0){
                start ++;
            }

            if(nonzero <= start) nonzero = start + 1;
            while(nonzero < n && nums[nonzero] == 0){
                nonzero ++;
            }
            if( start < n &&  nonzero <n && start!=nonzero){
                int tmp = nums[start];
                nums[start] = nums[nonzero];
                nums[nonzero] = tmp;
                start++;
            }
        }
    }
}
