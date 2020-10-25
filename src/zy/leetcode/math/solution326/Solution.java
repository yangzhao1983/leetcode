package zy.leetcode.math.solution326;

public class Solution {
    /**
     * 3: 11
     * 9: 1001
     * 27: 11011
     * 81: 11011
     * 11011
     * 1010001
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
