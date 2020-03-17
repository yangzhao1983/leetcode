package zy.leetcode.queue.solution7;

import java.util.LinkedList;

public class Solution {
    public int reverse(int x) {
        LinkedList<Integer> dq = new LinkedList<>();

        int sign = x < 0 ? -1 : 1;
        int cur = Math.abs(x);
        while(cur > 0){
            dq.push(cur%10);
            cur /= 10;
        }

        int ans = 0;
        while(dq.size() > 0){
            int op = dq.pollLast();
            if(ans > (Integer.MAX_VALUE-op)/10){
                return 0;
            }

            ans =ans * 10 +  op;
        }

        return sign * ans;
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.reverse(123));
    }

    private static void test2(){
        Solution sol = new Solution();
        System.out.println(sol.reverse(-123));
    }

    private static void test3(){
        Solution sol = new Solution();
        System.out.println(sol.reverse(120));
    }

    private static void test4(){
        Solution sol = new Solution();
        System.out.println(sol.reverse(1534236469));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
    }
}
