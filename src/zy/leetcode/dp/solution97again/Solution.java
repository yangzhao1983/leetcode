package zy.leetcode.dp.solution97again;

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

        int m = s1.length();
        int n = s2.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else {
                    if (i > 0 && dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        dp[i][j] = true;
                    else if (j > 0 && dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        dp[i][j] = true;
                }
            }
        }

        return dp[m][n];
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        String s1 = "aabc", s2 = "abad", s3 = "aabadabc";
        Assert.assertEquals(true, sol.isInterleave(s1, s2, s3));
    }
}
