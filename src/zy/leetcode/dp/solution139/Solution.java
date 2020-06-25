package zy.leetcode.dp.solution139;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //1. list->map, get max len
        //2. dp[i] for j in [i-1-max_len, i-1], dp[i] && s[j-1, i] in map
        int maxLen = 0;
        Set<String> words = new HashSet<String>();
        for(int i = 0; i < wordDict.size(); i++){
            words.add(wordDict.get(i));
            if(wordDict.get(i).length() > maxLen){
                maxLen = wordDict.get(i).length();
            }
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i = 1; i < dp.length; i++){
            for(int j = i-maxLen >= 0 ? i-maxLen : 0; j < i; j++){
                if(dp[j] && words.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    @Test
    public void test1(){
        String s = "leetcode";

        List<String> wordDict =new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.wordBreak(s, wordDict));
    }
}
