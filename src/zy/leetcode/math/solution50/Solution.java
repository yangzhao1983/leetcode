package zy.leetcode.math.solution50;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * n
     * mid = n/2
     * pow(x, n) = pow(x,mid) * pow(x, mid) * x (if n is odd)
     *
     * pow(x, n) = 1/pow(x, -n), if n < 0
     * if n < - integer.max
     * pow(x, n) = 1/pow(x, n/2)* pow(x, n/2) * x (if n is odd)
     *
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n > 0) {
            return doPow(x, n);
        } else if (n < -Integer.MAX_VALUE) {
            double addition = n % 2 == 1 ? x : 1;
            double half = doPow(x, -(n / 2));
            return 1 / (half * half * addition);
        } else {
            return 1/doPow(x, -n);
        }
    }

    private double doPow(double x, int m){

        if(m == 0){
            return 1;
        } else{
            double addition = m%2==1 ? x : 1;
            double half = doPow(x, m/2);
            return half * half * addition;
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(1024.0, sol.myPow(2.0,10),0);
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals(0.25, sol.myPow(2,-2),0);
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        Assert.assertEquals(0, sol.myPow(2,Integer.MIN_VALUE),0);
    }
}
