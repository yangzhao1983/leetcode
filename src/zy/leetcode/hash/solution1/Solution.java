package zy.leetcode.hash.solution1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i != map.get(nums[i])) return new int[]{i, map.get(nums[i])};
        }

        return null;
    }
}
