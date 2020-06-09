package zy.leetcode.dp.interview46;

public class Solution {
    /***
     * 111
     * 101
     * 110
     *
     */
    public int translateNum(int num) {
        if(num < 10){
            return 1;
        }

        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            if(!s.substring(i-2,i-1).equals("0") && isLetter(s, i-2, i)){
                dp[i] += dp[i-2];
            }
            dp[i] += dp[i-1];
        }
        return dp[dp.length-1];
    }

    private boolean isLetter(String s, int start, int end){
        int n = Integer.parseInt(s.substring(start, end));
        if(n>=0 && n <=25)
            return true;
        else
            return false;
    }
}
