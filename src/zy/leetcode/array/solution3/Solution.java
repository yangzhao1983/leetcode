package zy.leetcode.array.solution3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * for each char of s, c
     * if c in list, get index, maxLen = list.len, remove 0-index_of_c from list
     * else, add c to list
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s==null){
            return 0;
        }
        if(s.length() <= 1){
            return s.length();
        }

        List<Character> cList = new ArrayList<>();
        int maxLen = 0;

        for(Character c : s.toCharArray()){
            if(cList.contains(c)){
                if (cList.size() > maxLen){
                    maxLen = cList.size();
                }
                cList = cList.subList(cList.indexOf(c) +1, cList.size());
            }
            cList.add(c);

        }
        return cList.size() > maxLen ? cList.size() : maxLen;
    }

    private static void test5(){
        Solution sol = new Solution();
        String s = "aab";
        System.out.println(sol.lengthOfLongestSubstring(s));
    }

    private static void test1(){
        Solution sol = new Solution();
        String s = "abcabcbb";
        System.out.println(sol.lengthOfLongestSubstring(s));
    }

    private static void test2(){
        Solution sol = new Solution();
        String s = "abc";
        System.out.println(sol.lengthOfLongestSubstring(s));
    }

    private static void test3(){
        Solution sol = new Solution();
        String s = "bbbbb";
        System.out.println(sol.lengthOfLongestSubstring(s));
    }

    private static void test4(){
        Solution sol = new Solution();
        String s = "pwwkew";
        System.out.println(sol.lengthOfLongestSubstring(s));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
