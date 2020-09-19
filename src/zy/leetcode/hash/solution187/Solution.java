package zy.leetcode.hash.solution187;

import java.util.*;

public class Solution {
    private int P_LEN = 10;
    public List<String> findRepeatedDnaSequences(String s) {
        int a = 4;
        int n = s.length();
        int aL = (int)Math.pow(a, P_LEN);

        // convert string to array of integers
        Map<Character, Integer> toInt = new
                HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
        int h = 0;

        int[] nums = new int[n];
        for(int i = 0; i < n; i ++) nums[i] = toInt.get(s.charAt(i));

        Set<Integer> seen = new HashSet<>();
        Set<String> ans = new HashSet<>();

        for(int start = 0; start <= n - P_LEN; start++){
            if(start == 0){
                for(int i = 0; i < P_LEN; i++) h = h * a + nums[i];
            }else{
                h = h * a - nums[start - 1] * aL + nums[start + P_LEN - 1];
            }
            if(seen.contains(h)) ans.add(s.substring(start, start + P_LEN));
            seen.add(h);
        }
        return new ArrayList<String>(ans);
    }
}
