package zy.leetcode.string.solution87;

import org.junit.Assert;
import org.junit.Test;
import sun.awt.geom.AreaOp;

public class Solution {
    public boolean isScramble(String s1, String s2) {
        return doCompare(s1, s2, 0, s1.length() - 1, 0, s2.length() - 1);
    }

    private boolean doCompare(String s1, String s2, int start1, int end1, int start2, int end2) {
        if (start1 == end1) {
            return s1.substring(start1, start1 + 1).equals(s2.substring(start2, start2 + 1));
        }

        for (int i = start2; i < end2; i++) {
            // left vs left, right vs right
            if (doCompare(s1, s2, start1, start1 + i - start2, start2, i)
                    && doCompare(s1, s2, start1 + i - start2 + 1, end1, i + 1, end2))
                return true;

            // left vs right, right vs left
            if (doCompare(s1, s2, end1 - (i - start2), end1, start2, i) &&
                    doCompare(s1, s2, start1, end1 - (i - start2) - 1, i + 1, end2))
                return true;
        }
        return false;
    }

    @Test
    public void test1(){
        String s1 = "great", s2 = "rgeat";
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isScramble(s1, s2));
    }

    @Test
    public void test2(){
        String s1 = "abcde", s2 = "caebd";
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isScramble(s1, s2));
    }
}
