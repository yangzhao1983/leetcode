package zy.leetcode.hash.solution349;

import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num1 : nums1) {
            set.add(num1);
        }
        for (int num2 : nums2) {
            if (set.contains(num2)) {
                list.add(num2);
                set.remove(num2);
            }
        }
        if (list.size() == 0) return new int[0];
        else {
            int[] ans = new int[list.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
}
