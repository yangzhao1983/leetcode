package zy.leetcode.dp.solution696;

public class Solution {
    public int countBinarySubstrings(String s) {
        if(s==null || s.length() == 0){
            return 0;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int ans = 0;

        for(int step = 1; step < n; step+= 2){
            for(int i = 0; i < n;i++){
                int j = i + step;
                if(j < n){
                    if(step == 1){
                        dp[i][j] = s.charAt(i) != s.charAt(j);
                    }else{
                        dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(i+1)) && (s.charAt(j) == s.charAt(j-1));
                    }
                    if(dp[i][j]) ans++;
                }
            }
        }

        return ans;
    }
}
