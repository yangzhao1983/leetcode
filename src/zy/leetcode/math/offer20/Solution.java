package zy.leetcode.math.offer20;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) return false;

        String trimmed = s.trim();
        boolean started = false;
        boolean hitE = false;
        boolean hitDigital = false;
        boolean hitPoint = false;
        boolean endWithDigital = false;

        for (int i = 0; i < trimmed.length(); i++) {
            char cur = trimmed.charAt(i);
            if (cur == ' ') {
                return false;
            } else if (cur == '+' || cur == '-') {
                if (started && trimmed.charAt(i - 1) != 'E' && trimmed.charAt(i - 1) != 'e') return false;

            } else if (cur == '.') {
                if (hitPoint) {
                    return false;
                } else if (hitE) {
                    return false;
                }
                hitPoint = true;
            } else if (cur == 'e' || cur == 'E') {
                if (!hitDigital || hitE) return false;
                hitE = true;
            } else if (cur >= '0' && cur <= '9') {
                if (!hitDigital) hitDigital = true;
                if (i==trimmed.length()-1) endWithDigital = true;
            } else{
                return false;
            }
            if (!started) started = true;
        }

        if (trimmed.length() > 0 && !hitDigital) return false;
        if(hitE && !endWithDigital) return false;

        return true;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isNumber(" 0"));
    }
}
