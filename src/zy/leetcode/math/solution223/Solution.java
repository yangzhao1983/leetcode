package zy.leetcode.math.solution223;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // area1
        // area2
        // common area:
        // left line, max(L)
        // right line, min(R)
        // top line, min(Top)
        // bottom line, max(Bottom)
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        if (E >= C || G <= A || F >= D || H <= B) {
            return area1 + area2;
        }

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);

        int common = 0;
        int ver = top - bottom;
        int hor = right - left;
        if (ver > 0 && hor > 0) {
            common = ver * hor;
        }

        return area1 + area2 - common;
    }

    @Test
    public void test1() {
        Solution sol = new Solution();
        Assert.assertEquals(17, sol.computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.computeArea(
                -1500000001,
                0,
                -1500000000,
                1,
                1500000000,
                0,
                1500000001,
                1));
    }
}
