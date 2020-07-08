package zy.leetcode.backtracking.solution132;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {
    private boolean[][] dp;
    private String s;
    private List<List<String>> ans = new ArrayList<>();

    private void buildDp(){
        int length = s.length();
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }
    }

    public int minCut(String s) {
        if(s==null || s.length()==0){
            return 0;
        }

        dp = new boolean[s.length()][s.length()];
        this.s = s;

        // build dp for palindrome
        buildDp();

        return doBacktracking(0, new HashMap<>());
    }

    private int doBacktracking(int start, HashMap<Integer, Integer> map){

        if (map.containsKey(start)) {
            return map.get(start);
        }
        if (dp[start][s.length() - 1]) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                min = Math.min(min, 1 + doBacktracking(i + 1, map));
            }
        }
        map.put(start, min);
        return min;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        String s= "aab";
        Assert.assertEquals(1, sol.minCut(s));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        String s= "ababababababababababababcbabababababababababababa";
        Assert.assertEquals(0, sol.minCut(s));
    }
}
