package zy.leetcode.twopointers.solution58;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0){
            return 0;
        }

        int end = s.length()-1;
        while(end>=0 && s.charAt(end)==' '){
            end--;
        }
        if(end < 0){
            return 0;
        }
        int start = end;
        while(start >=0 && s.charAt(start) != ' '){
            start --;
        }
        return end - start;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(5, sol.lengthOfLastWord("Hello World"));
    }
}
