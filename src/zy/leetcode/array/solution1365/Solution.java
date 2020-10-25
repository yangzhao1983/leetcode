package zy.leetcode.array.solution1365;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        int[] cum = new int[101];
        for(int num : nums){
            cnt[num] ++;
        }
        int cur = 0;
        for(int i = 0; i < 101; i++){
            cum[i] = cur;
            cur += cnt[i];
        }
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ans[i] = cum[nums[i]];
        }
        return ans;
    }
}
