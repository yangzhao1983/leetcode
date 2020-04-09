package zy.leetcode.stack.solution151;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * two pointers,
     * first move until non-space
     * second move until space
     *
     * stack
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    @Test
    public void test1(){
        String s = "the sky is blue";
        Solution sol = new Solution();
        Assert.assertEquals("blue is sky the", sol.reverseWords(s));
    }
}
