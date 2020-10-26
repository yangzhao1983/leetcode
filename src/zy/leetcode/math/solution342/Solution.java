package zy.leetcode.math.solution342;

public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num < 1) return false;
        String s= Integer.toString(num, 4);
        return s.matches("^10*$");
    }
}
