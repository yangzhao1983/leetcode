package zy.leetcode.array.solution229;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int[] major = new int[2];
        int[] count = new int[2];
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        Arrays.fill(major, nums[0]);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major[0]) {
                count[0]++;
            } else if (nums[i] == major[1]) {
                count[1]++;
            } else {
                if (count[0] > 0) {
                    if (count[1] == 0) {
                        major[1] = nums[i];
                        count[1] = 1;
                    } else {
                        count[0]--;
                        count[1]--;
                    }
                } else {
                    major[0] = nums[i];
                    count[0] = 1;

                }
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major[0]) cnt1++;
            else if (nums[i] == major[1]) cnt2++;
        }
        if (cnt1 > nums.length / 3) {
            ans.add(major[0]);
        }
        if (cnt2 > nums.length / 3) {
            ans.add(major[1]);
        }
        return ans;
    }

    @Test
    public void test1() {
        Solution sol = new Solution();
        List<Integer> ans = sol.majorityElement(new int[]{2, 2});
        System.out.println();
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        List<Integer> ans = sol.majorityElement(new int[]{6, 5, 5});
        System.out.println();
    }
}
