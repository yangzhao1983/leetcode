package zy.leetcode.dp.solution97;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1 == null) s1 = "";
        if (s2 == null) s2 = "";
        if (s3 == null) s3 = "";

        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        // dp[i][j]: first i chars in s1 and first j chars can inter leave first k chars in s3
        // i + j = k
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        int k = 0;


        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length;j++){
                if(i==0 && j==0){
                    dp[0][0] = true;
                }else{
                    k = i + j;
                    if(i >0 && dp[i-1][j] && s1.substring(i-1, i).equals(s3.substring(k-1, k))){
                        dp[i][j] = true;
                    }else if(j >0 && dp[i][j-1] && s2.substring(j-1, j).equals(s3.substring(k-1, k))){
                        dp[i][j] =true;
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }


    @Test
    public void test1() {
        Solution sol = new Solution();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Assert.assertEquals(true, sol.isInterleave(s1, s2, s3));
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        Assert.assertEquals(false, sol.isInterleave(s1, s2, s3));
    }
}
