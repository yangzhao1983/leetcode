package zy.leetcode.sortandsearch.solution220;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {
    /**
     * nums[i], check nums[i+1]... nums[i+k-1]
     *          if exist |nums[j] = nums[i]| <=t
     *
     *
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= (long)(nums[i] + t)) return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null ){
                long border = ((long)g + t);
                if(nums[i] <= border) return true;
            }

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    @Test
    public void test1(){
        int[] nums = {2147483640,2147483641};
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.containsNearbyAlmostDuplicate(nums, 1, 100));
    }
}
