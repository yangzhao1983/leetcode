package zy.leetcode.string.solution214;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    private boolean isOdd = true;

    /**
     * start from mid.
     * len is odd: check
     * len is even: check
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        // check if adding chars in the front can transform it to be a palindrome
        int n = s.length();

        if (n % 2 == 0) {
            isOdd = false;
        }
        int mid = n / 2;
        for (int i = mid; i >= 0;) {
            if (isOdd) {
                String rel = doCheck(s, i);
                if (!rel.equals("")) return rel;
                else {
                    isOdd = false;
                }
            } else {
                if (i > 0 && s.substring(i - 1, i).equals(s.substring(i, i + 1))) {
                    String rel = doCheck(s, i);
                    if (!rel.equals("")) return rel;
                }
                isOdd = true;
                i--;
            }
        }
        return "";
    }

    /**
     * @param s
     * @param mid
     * @return
     */
    private String doCheck(String s, int mid) {
        // return string with odd length
        // radium = s.len - 1 - mid

        // return string with even length
        // if s[mid] == s[mid-1], radium = len-1-mid
        int l = 0, r = 0;

        if (isOdd) {
            l = mid - 1;
        } else {
            l = mid - 2;
        }
        r = mid + 1;

        while (l >= 0 && s.substring(l, l + 1).equals(s.substring(r, r + 1))) {
            l--;
            r++;
        }
        if (r == s.length()) {
            return s;
        } else if (l >= 0) {
            return "";
        } else {
            String rel = s;
            for (int i = r; i < s.length(); i++) {
                rel = s.substring(i, i + 1) + rel;
            }
            return rel;
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals("aaacecaaa", sol.shortestPalindrome("aacecaaa"));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals("dcbabcd", sol.shortestPalindrome("abcd"));
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        Assert.assertEquals("dcabbacd", sol.shortestPalindrome("abbacd"));
    }
}