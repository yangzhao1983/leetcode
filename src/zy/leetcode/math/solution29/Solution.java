package zy.leetcode.math.solution29;

import sun.nio.cs.ext.MacArabic;

public class Solution {
    public int divide(int dividend, int divisor) {

        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        int flag = (dividend ^ divisor) < 0 ? -1 : 1;
        long[] ans = doDivide(Math.abs((long)dividend), Math.abs((long)divisor));

        return flag == -1 ? (int)(0 - ans[0]) : (int)ans[0];
    }

    private long[] doDivide(long dividend, long divisor){
        if(dividend == 0){
            return new long[]{0,0};
        }

        long newDividend = dividend >> 1;
        long[] rel = doDivide(newDividend, divisor);
        rel[0] = rel[0]<<1;
        rel[1] = rel[1]<<1;
        if((dividend>>1)<<1 != dividend){
            rel[1]++;
        }
        if(rel[1] >= divisor){
            rel[1] -= divisor;
            rel[0]++;
        }

        return rel;
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.divide(10,5));
    }

    private static void test2(){
        Solution sol = new Solution();
        System.out.println(sol.divide(10,-5));
    }

    private static void test3(){
        Solution sol = new Solution();
        System.out.println(sol.divide(-10,5));
    }

    private static void test4(){
        Solution sol = new Solution();
        System.out.println(sol.divide(-10,-5));
    }

    private static void test5(){
        Solution sol = new Solution();
        System.out.println(sol.divide(10,6));
    }

    private static void test6(){
        Solution sol = new Solution();
        System.out.println(sol.divide(10,-6));
    }

    private static void test7(){
        Solution sol = new Solution();
        System.out.println(sol.divide(-10,6));
    }

    private static void test8(){
        Solution sol = new Solution();
        System.out.println(sol.divide(-10,-6));
    }

    private static void test9(){
        Solution sol = new Solution();
        System.out.println(sol.divide(Integer.MIN_VALUE,1));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
//        System.out.println(Integer.MIN_VALUE/-1);
//        System.out.println(Integer.MIN_VALUE>>1);
    }
}
