package zy.leetcode.bit.solution201;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * threshold
     * 1, 2, 4, 8, 16, 32, 64
     *
     * if [m, n] contains two thresholds, then the ans is 0.
     * else f(m,n) = threshold
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while(n > m){
            n = n >> 1;
            m = m >> 1;
            cnt ++;
        }
        return n << cnt;
    }

    @Test
    public void test(){
        Solution sol = new Solution();
        Assert.assertEquals(4, sol.rangeBitwiseAnd(5,7));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals(0, sol.rangeBitwiseAnd(1,2));
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        Assert.assertEquals(0, sol.rangeBitwiseAnd(2,4));
    }
}
