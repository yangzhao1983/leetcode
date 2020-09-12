package zy.leetcode.mysort.solution179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strNums = new String[n];
        for(int i = 0; i < n; i++) strNums[i] = String.valueOf(nums[i]);

        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String first = o1 + o2;
                String second = o2 + o1;
                return second.compareTo(first);
            }
        });

        if (strNums[0].equals("0")) {
            return "0";
        }

        String ans = "";

        for(String str : strNums){
            ans += str;
        }
        return ans;
    }
}
