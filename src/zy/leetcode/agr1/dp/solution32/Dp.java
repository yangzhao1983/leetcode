package zy.leetcode.agr1.dp.solution32;

import java.util.Arrays;

/**
 * Created by kaiser_zhao on 2019/8/29.
 */
public class Dp {

    public static void main(String...strings){
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("()()"));
        System.out.println(longestValidParentheses("())"));
        System.out.println(longestValidParentheses("(()())"));
    }


    public static int longestValidParentheses(String s) {

        if(s==null || s.length() <=1){
            return 0;
        }

        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);

        int max = 0;

        for(int i = 1; i< s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = i > 1? 2+ dp[i-2] : 2;
                }else if (i-dp[i-1] -1 >=0 && s.charAt(i-dp[i-1] -1) == '('){
                    dp[i] = i-dp[i-1]-2 > 0? dp[i-1] + 2 + dp[i-dp[i-1]-2] : dp[i-1] + 2;
                }
            }
            if (max < dp[i]){
                max = dp[i];
            }
        }

        return max;
    }
}
