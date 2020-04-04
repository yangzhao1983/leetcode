package zy.leetcode.dp.solution43;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * DP
     *
     * match[i][j]
     *
     * where match[i][j] == true,
     * s[0-i-1] match p[0-j-1]
     *
     * so match[i][j] == true <=
     * match[i-1][j-1], s[i-1] = p[j-1]
     * or
     * match[i-1][j-1], p[j-1] = ?/*
     * or
     * match[0, i-1][j], p[j-1]= *
     *
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;
        for(int i = 0; i < s.length()+1; i++){
            for(int j = 0; j < p.length()+1; j++){
                boolean hitStart = false;
                if(j > 0){
                    hitStart = "*".equals(p.substring(j-1, j));
                }
                if( i>0 && j>0  && (match[i-1][j-1] && (s.substring(i-1, i).equals(p.substring(j-1, j))))
                || (i> 0 && j>0 && match[i-1][j-1] && (hitStart || "?".equals(p.substring(j-1, j))))
                        || ( j > 0 && match[i][j-1] && hitStart)
                || (i > 0 && hitStart && match[i-1][j])){
                    match[i][j] = true;
                }
            }
        }
        return match[s.length()][p.length()];
    }

    @Test
    public void test1(){
        String s = "aa";
        String p = "a";
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isMatch(s, p));
    }

    @Test
    public void test2(){
        String s = "aa";
        String p = "*";
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isMatch(s, p));
    }

    @Test
    public void test3(){
        String s = "cb";
        String p = "?a";
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isMatch(s, p));
    }

    @Test
    public void test4(){
        String s = "adceb";
        String p = "*a*b";
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isMatch(s, p));
    }

    @Test
    public void test5(){
        String s = "acdcb";
        String p = "a*c?b";
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isMatch(s, p));
    }
}
