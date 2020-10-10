package zy.leetcode.twopointers.solution287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(nums[slow] == nums[fast]) break;
        }
        int pre = 0;
        while(nums[pre]!=nums[slow]){
            pre = nums[pre];
            slow = nums[slow];
        }
        return nums[pre];
    }
}
