package zy.leetcode.dp.solution44;

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || s.length()==0){
           if (p==null || p.length()==0 || p.equals("*")) return true;
           else return false;
        }
        if (p==null || p.length()==0) return false;

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (j == 0) {
                    dp[i][j] = false;
                } else {
                    String curP = p.substring(j - 1, j);
                    if (curP.equals("*")) {
                        for (int k = i; k >= 0; k--) {
                            if (dp[k][j - 1]) {
                                dp[i][j] = true;
                                break;
                            }
                        }
                    } else if (i > 0 && (curP.equals("?") || curP.equals(s.substring(i - 1, i))) )
                        dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
