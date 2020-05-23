package zy.leetcode.dp.solution87;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public boolean isScramble(String s1, String s2) {

        // int[i][j][len] == 1: substring s1[i..i+len-1] can be scrambled to s2[j..j+len-1]
        // int[i][j][len] == 0: substring s1[i..i+len-1] can't be scrambled to s2[j..j+len-1]
        int[][][] dp = new int[s1.length()][s2.length()][s1.length()+1];

        dp[0][0][0] = 1;

        // initialize len==1 and len==0
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                dp[i][j][0] = 1;
                dp[i][j][1] = s1.substring(i, i+1).equals(s2.substring(j, j+1))?1:0;
            }
        }

        for(int m = 2; m <= s1.length(); m++){
            for(int i = 0; i <= s1.length() - m; i++){
                for(int j = 0; j <= s2.length()-m; j++){
                    // left vs left, right vs right
                    for(int w = 1; w <= m-1; w++){
                        if(dp[i][j][w] == 1 && dp[i+w][j+w][m-w]==1){
                            dp[i][j][m] = 1;
                            break;
                        }
                    }
                    // left vs right, right vs left
                    for(int w = 1; w <= m-1; w++){
                        if(dp[i][j+m-w][w] == 1 && dp[i+w][j][m-w]==1){
                            dp[i][j][m] = 1;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0][s1.length()] == 1;
    }

    @Test
    public void test1(){
        String s1 = "great", s2 = "rgeat";
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isScramble(s1, s2));
    }

    @Test
    public void test2(){
        String s1 = "abcde", s2 = "caebd";
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isScramble(s1, s2));
    }

    @Test
    public void test3(){
        String s1 = "pknsvxobynprj", s2 = "kobvyxnjrppsn";
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isScramble(s1, s2));
    }
}
