package zy.leetcode.dp.solution97B;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1 == null) s1 = "";
        if (s2 == null) s2 = "";
        if (s3 == null) s3 = "";

        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        int[][] dp = new int[s3.length() + 1][2];
        dp[0][0] = dp[0][1] = -1;

        return checkNext(dp, 1, s1, s2, s3);
    }

    private boolean checkNext(int[][] dp, int i, String s1, String s2, String s3) {
        if(i == dp.length){
            return true;
        }

        dp[i][0] = dp[i - 1][0];
        dp[i][1] = dp[i - 1][1];
        if (s1.length() - 1 > dp[i - 1][0] && s3.substring(i - 1, i).equals(s1.substring(dp[i - 1][0] + 1, dp[i - 1][0] + 2))) {
            dp[i][0]++;
            if (checkNext(dp, i + 1, s1, s2, s3)) return true;
            dp[i][0] = dp[i-1][0];
        }

        if (s2.length() - 1 > dp[i - 1][1] && s3.substring(i - 1, i).equals(s2.substring(dp[i - 1][1] + 1, dp[i - 1][1] + 2)
        )) {
            dp[i][1]++;
            if (checkNext(dp, i + 1, s1, s2, s3)) return true;
            dp[i][1] = dp[i-1][1];
        }
        return false;
    }
}
