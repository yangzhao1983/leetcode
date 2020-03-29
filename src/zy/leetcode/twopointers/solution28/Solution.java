package zy.leetcode.twopointers.solution28;

public class Solution {

    public int strStr(String haystack, String needle) {
        if(needle == ""){
            return 0;
        }
        int end = haystack.length() - needle.length();
        for(int i = 0; i<= end; i++){
            int p = i;
            int j = 0;
            while(p < haystack.length() && j<needle.length()&& haystack.charAt(p) == needle.charAt(j)) {
                j++;
                p++;
            }
            if(j == needle.length()){
                return i;
            }
        }
        return -1;
    }

    private static void test1(){
        Solution sol = new Solution();
        String haystack = "hello";
        String needle = "ll";
        System.out.println(sol.strStr(haystack,needle));
    }

    private static void test2(){
        Solution sol = new Solution();
        String haystack = "aaa";
        String needle = "aaa";
        System.out.println(sol.strStr(haystack,needle));
    }

    public static void main(String...strings){
        test1();
        test2();
    }
}
