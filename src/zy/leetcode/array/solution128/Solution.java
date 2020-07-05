package zy.leetcode.array.solution128;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : nums){
            map.put(num, Boolean.FALSE);
        }
        int ans = 0;
        for(int i = 0; i<nums.length;i++){
            int k = 1;
            if(nums[i] == Integer.MIN_VALUE || !map.containsKey(nums[i]-1)|| !map.get(nums[i]-1)){
                map.put(nums[i], Boolean.TRUE);
                while(k<nums.length && map.containsKey(nums[i] + k)){
                    k++;
                    map.put(nums[i]+1, Boolean.TRUE);
                }
            }
            ans = Math.max(ans, k);
        }
        return ans;
    }

    @Test
    public void test1(){
        int[] nums = {100, 4, 200, 1, 3, 2};
        Solution sol = new Solution();
        Assert.assertEquals(4, sol.longestConsecutive(nums));
    }
}
