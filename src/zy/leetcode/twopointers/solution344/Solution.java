package zy.leetcode.twopointers.solution344;

public class Solution {
    public void reverseString(char[] s) {
        if(s == null || s.length <=1) return;
        int l = 0;
        int r = s.length - 1;
        while(l < r){
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            r--;
            l++;
        }
    }
}
