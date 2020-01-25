package zy.leetcode.dp.solution32;

import java.util.Arrays;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] longestValidNum = new int[s.length()];
        longestValidNum[0] = 0;
        int maxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    longestValidNum[i] = i - 2 > 0 ? longestValidNum[i - 2] + 2 : 2;
                } else {
                    int prePre = i - longestValidNum[i - 1] - 1;
                    if (prePre >= 1 && s.charAt(prePre) == '(') {
                        longestValidNum[i] = longestValidNum[prePre - 1] + 2 + longestValidNum[i - 1];
                    } else if (prePre == 0 && s.charAt(prePre) == '(') {
                        longestValidNum[i] = 2 + longestValidNum[i - 1];
                    } else {
                        longestValidNum[i] = 0;
                    }
                }

                if (longestValidNum[i] > maxLen) {
                    maxLen = longestValidNum[i];
                }
            }
        }
        return maxLen;
    }

    private static void test1() {
        System.out.println(new Solution().longestValidParentheses(")()())"));
    }

    private static void test2() {
        System.out.println(new Solution().longestValidParentheses("(()"));
    }

    private static void test3() {
        System.out.println(new Solution().longestValidParentheses("())"));
    }

    private static void test4() {
        System.out.println(new Solution().longestValidParentheses("()(())"));
    }

    public static void main(String... strings) {
        test1();
        test2();
        test3();
        test4();
    }
}
