package zy.leetcode.string.solution459;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * step = [2..n/2]
     *
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()==1) return false;
        else if(s.length()==2) return s.charAt(0) == s.charAt(1);
        int n = s.length();
        for(int step = n/2; step >0;step--){
            if(n%step==0){
                String base = s.substring(0, step);
                int j = step;
                while(j <n){
                    if(!s.substring(j, j+step).equals(base))break;
                    j += step;
                }
                if(j == n) return true;
            }
        }
        return false;
    }

    @Test
    public void test1(){
        String s = "abab";
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.repeatedSubstringPattern(s));
    }
}
