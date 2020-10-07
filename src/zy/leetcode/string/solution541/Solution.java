package zy.leetcode.string.solution541;

public class Solution {
    public String reverseStr(String s, int k) {
        if(s == null || s.length() <= 1) return s;
        char[] cs = s.toCharArray();
        int b = 0;
        int f = -1;
        while( f < s.length()){
            f += 2* k;
            if(f < s.length()) reverse(cs, b, b+k-1);
            else if( b + k -1 < s.length()) reverse(cs, b, b+k-1);
            else reverse(cs, b, s.length()-1);
            b = f + 1;
        }
        return String.valueOf(cs);
    }

    private void reverse(char[] cs, int l, int r){
        while(l < r){
            if(cs[l] != cs[r]){
                char c = cs[l];
                cs[l] = cs[r];
                cs[r] = c;
            }
            l++;
            r--;
        }
    }
}
