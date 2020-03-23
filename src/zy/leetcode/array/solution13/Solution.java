package zy.leetcode.array.solution13;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans = 0;
        int last = Integer.MAX_VALUE;
        for(int i = 0; i< s.length(); i++){
            int curNum = map.get(s.charAt(i));
            if(last < curNum){
                ans = ans + curNum -  2 * last;
            }else{
                ans = ans + curNum;
            }
            last = curNum;
        }
        return ans;
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("III"));
    }

    private static void test2(){
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("IV"));
    }

    private static void test3(){
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("IX"));
    }

    private static void test4(){
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("MCMXCIV"));
    }

    private static void test5(){
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("LVIII"));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
