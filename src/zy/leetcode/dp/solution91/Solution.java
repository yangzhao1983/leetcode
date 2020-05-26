package zy.leetcode.dp.solution91;

public class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];

        dp[0] = 1;

        char pre;
        char cur;

        if(s.charAt(0)=='0'){
            dp[1] = 0;
        }else{
            dp[1] = 1;
        }

        for(int i = 2; i <= s.length(); i++){
            cur = s.charAt(i-1);
            pre = s.charAt(i-2);

            if((pre=='1' && (cur >='0' && cur <= '9')) || (pre=='2' && (cur >= '0' && cur <= '6'))){
                if(cur == '0'){
                    dp[i] = dp[i-2];
                }else{
                    dp[i] = dp[i-1] + dp[i-2];
                }
            }else{
                if(cur == '0'){
                    return 0;
                }
                dp[i] = dp[i-1];
            }
        }

        return dp[s.length()];
    }
}
