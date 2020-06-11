package zy.leetcode.dp.solution115;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * dp[i][j]:
     * if S[j] == T[len-i] and dp[i-1][j'] > 0
     *  the number of distinct subsequences of S[len-j,len-1] which equals T[len-i,len-1].
     * else
     *  dp[i][j] = 0
     *
     *  dp[i][j] = dp[i][j'] + 1
     *
     *  max(j' >j) and dp[i-1][j']>0
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if(s==null || t==null || s.length()==0 || t.length()==0){
            return 0;
        }else if(s.length() < t.length()){
            return 0;
        }

        int[][] dp = new int[t.length()][s.length()];
        int count = 0;
        for(int j = s.length()-1; j >=0 ; j--){
            if(s.substring(j, j+1).equals(t.substring(t.length()-1))){
                dp[0][j] = ++count;
            }else{
                dp[0][j] = count;
            }
        }

        for(int i = 1; i < t.length(); i++){
            for(int j = s.length()-i-1; j>=0; j--){
                if(s.substring(j,j+1).equals(t.substring(t.length()-i-1, t.length()-i))){
                    dp[i][j] = dp[i-1][j+1] + dp[i][j+1];
                }else{
                    dp[i][j] = dp[i][j+1];
                }
            }
        }

        return dp[t.length()-1][0];
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(3, sol.numDistinct("rabbbit", "rabbit"));
    }
}
