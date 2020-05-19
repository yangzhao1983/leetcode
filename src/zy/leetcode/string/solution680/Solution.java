package zy.leetcode.string.solution680;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    private boolean foundDiff = false;
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        return doValidPalindrome(s, left, right);
    }

    private boolean doValidPalindrome(String s, int left, int right){

        if(left >= right){
            return true;
        }

        if(s.charAt(left) == s.charAt(right)){
            return doValidPalindrome(s, left+1, right-1);
        }else{
            if (foundDiff) return false;
            foundDiff = true;
            if(doValidPalindrome(s, left+1, right)) return true;
            else return doValidPalindrome(s, left, right-1);
        }
    }

    /**
     * abacab
     *
     *
     *
     */
    @Test
    public void test1(){
        String s = "aguokepatg" +
                   "bnvfqmgmlc" +
                   "upuufxoohd" +
                   "fpgjdmysgv" +
                   "hmvffcnqxj" +
                   "jxqncffvmh" +
                   "vgsymdjgpf" +
                   "dhooxfuupu" +
                   "culmgmqfvn" +
                   "b" +
                   "gtapekouga";
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.validPalindrome(s));
    }

    @Test
    public void test2(){
        String s = "abc";
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.validPalindrome(s));
    }
}
