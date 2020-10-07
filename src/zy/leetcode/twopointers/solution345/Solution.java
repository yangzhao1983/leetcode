package zy.leetcode.twopointers.solution345;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('i');
        vowels.add('e');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('I');
        vowels.add('E');
        vowels.add('O');
        vowels.add('U');
        char[] cs = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !vowels.contains(cs[l])) l++;
            while (l < r && !vowels.contains(cs[r])) r--;
            if (l < r) {
                if (cs[l] != cs[r]) {
                    char c = cs[l];
                    cs[l] = cs[r];
                    cs[r] = c;
                }
                l++;
                r--;
            }
        }
        return String.valueOf(cs);
    }

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals("holle", sol.reverseVowels("hello"));
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        Assert.assertEquals("leotcede", sol.reverseVowels("leetcode"));
    }
}
