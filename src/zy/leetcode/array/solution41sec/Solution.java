package zy.leetcode.array.solution41sec;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length;
        boolean[] b = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n + 1) b[nums[i] - 1] = true;
        }
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            if (!b[i]){
                ans = i + 1;
                break;
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {1,2,0};
        Assert.assertEquals(3, sol.firstMissingPositive(nums));
    }
}
