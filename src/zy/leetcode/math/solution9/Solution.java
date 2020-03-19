package zy.leetcode.math.solution9;

public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int src = x;
        int tgt = 0;
        while(src > 0){
            tgt = tgt * 10 +  src%10;
            src /= 10;
        }
        return tgt == x;
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(121));
    }

    private static void test2(){
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(-121));
    }

    private static void test3(){
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(10));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
    }
}
