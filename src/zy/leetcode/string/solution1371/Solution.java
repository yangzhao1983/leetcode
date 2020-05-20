package zy.leetcode.string.solution1371;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution {

    public int findTheLongestSubstring(String s) {
        int[] evenOdd = new int[32];
        Arrays.fill(evenOdd, -1);
        int ans = 0;
        int cur = 0;
        evenOdd[0] = 0;
        int status = 0;
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case 'a': status ^= (1<<0);break;
                case 'e': status ^= (1<<1);break;
                case 'i': status ^= (1<<2);break;
                case 'o': status ^= (1<<3);break;
                case 'u': status ^= (1<<4);break;
            }
            if(evenOdd[status] < 0){
                evenOdd[status] = i + 1;
            }else{
                ans = Math.max(ans, i + 1 - evenOdd[status]);
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        String s =  "eleetminicoworoep";
        Solution sol = new Solution();
        Assert.assertEquals(13, sol.findTheLongestSubstring(s));
    }

    @Test
    public void test2(){
        String s =  "l" + "eetco" + "deisg" + "reat";
        Solution sol = new Solution();
        Assert.assertEquals(5, sol.findTheLongestSubstring(s));
    }
}
