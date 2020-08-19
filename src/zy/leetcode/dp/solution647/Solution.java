package zy.leetcode.dp.solution647;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int countSubstrings(String s) {
        if(s==null || s.length() == 0) return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for(int step = 0; step < n; step++){
            for(int i = 0; i < n-step; i++){
                if(step == 0){
                    dp[i][i+step] = true;
                    ans++;
                }else if(step == 1){
                    if(s.substring(i, i+1).equals(s.substring(i+1, i+2))) {
                        dp[i][i+step] = true;
                        ans++;
                    }
                }else{
                    if(s.substring(i,i+1).equals(s.substring(i+step,i+step+1)) && dp[i+1][i+step-1]){
                        dp[i][i+step] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        Solution sol = new Solution();
        Assert.assertEquals(6, sol.countSubstrings("aaa"));
    }
}
