package zy.leetcode.math.solution171;

public class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0; i<n; i++){
            ans = (s.charAt(i) - 'A' + 1) + ans * 26;
        }
        return ans;
    }
}
