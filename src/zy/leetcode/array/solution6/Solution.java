package zy.leetcode.array.solution6;

import com.sun.tools.javac.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    /**
     *
     * 0, n+(n-2), 2(n+(n-2))...
     * 0 + 1, n+(n-2)-1,n+(n-2)+1,2(n+(n-2))-1,...
     * 0+2, n+(n-2)-2, n+(n-2)+2...
     * 0+3, n+(n-2)-3
     * ..   n+(n-2)-n-2
     * n-1
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(s==null || s.length() ==0){
            return "";
        }else if (s.length()==1){
            return s;
        }else if(numRows==1){
            return s;
        }

        List<Character> ansList = new ArrayList<>();
        int sLen = s.length();
        for(int i = 0; i< numRows; i++){
            boolean inBaseCol = true;
            int curIndex = i;
            while(curIndex < sLen){
                if(inBaseCol){
                    if(i<numRows-1){
                        ansList.add(s.charAt(curIndex));
                    }
                    curIndex += 2*(numRows - 1 - i);
                    inBaseCol = false;
                }else{
                    if(i > 0){
                        ansList.add(s.charAt(curIndex));
                    }
                    curIndex += 2 * i;
                    inBaseCol = true;
                }
            }
        }
        return ansList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.convert("PAYPALISHIRING", 3));
        System.out.println(sol.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
    }

    private static void test2(){
        Solution sol = new Solution();
        System.out.println(sol.convert("PA", 3));
        System.out.println(sol.convert("PA", 3).equals("PA"));
    }

    private static void test3(){
        Solution sol = new Solution();
        System.out.println(sol.convert("PAYPALISHIRING", 4));
        System.out.println(sol.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
    }

    private static void test4(){
        Solution sol = new Solution();
        System.out.println(sol.convert("A", 1));
        System.out.println(sol.convert("A", 1).equals("A"));
    }

    private static void test5(){
        Solution sol = new Solution();
        System.out.println(sol.convert("A", 5));
        System.out.println(sol.convert("A", 5).equals("A"));
    }

    private static void test6(){
        Solution sol = new Solution();
        System.out.println(sol.convert("ABB", 1));
        System.out.println(sol.convert("ABB", 1).equals("ABB"));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
}
