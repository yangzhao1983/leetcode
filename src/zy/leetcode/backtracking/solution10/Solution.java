package zy.leetcode.backtracking.solution10;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int sStart, int pStart){
        if(sStart == s.length() && pStart == p.length()){
            return true;
        }else if(pStart >= p.length()){
            return false;
        }else if(sStart == s.length()){
            if(pStart <= p.length()-2 && p.charAt(pStart+1) == '*'){
                return isMatch(s,p,sStart, pStart+2);
            }else{
                return false;
            }
        }

        if(pStart <  p.length()-1 && p.charAt(pStart+1)=='*'){
            if(isMatch(s, p, sStart, pStart+2)) return true;

            char curP = p.charAt(pStart);

            int i = sStart;
            while(i < s.length() && (s.charAt(i) == curP || p.charAt(pStart)=='.')){
                if(isMatch(s, p, i+1, pStart+2)) return true;
                i++;
            }
            return false;
        }

        if(pStart <  p.length()-1 && p.charAt(pStart+1)=='+'){
            char curS = s.charAt(sStart);
            if(curS != p.charAt(pStart) && p.charAt(pStart)!='.') return false;

            int i = sStart;
            while(i < s.length() && (s.charAt(i) == curS || p.charAt(pStart)=='.')){
                if(isMatch(s, p, i+1, pStart+2)) return true;
                i++;
            }
            return false;
        }

        if(s.charAt(sStart) == p.charAt(pStart) || p.charAt(pStart) == '.'){
            return isMatch(s, p, sStart+1, pStart+1);
        }else{
            return false;
        }
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
        String s = "ab";
        String p = ".*c";
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isMatch(s, p));
    }

    @Test
    public void test3(){
        String s = "aaa";
        String p = "ab*a";
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isMatch(s, p));
    }

    @Test
    public void test4(){
        String s = "a";
        String p = "ab*";
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isMatch(s, p));
    }
}
