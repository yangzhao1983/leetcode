package zy.leetcode.stack.solution1111;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        Arrays.fill(ans, 1);
        int dep = 0;
        for(int i = 0; i < seq.length(); i++){
            if(seq.charAt(i) == '('){
                dep++;
                if(dep%2==1) {
                    ans[i] = 0;
                }
            }else{
                if(dep%2==1){
                    ans[i] = 0;
                }
                dep--;
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        String seq = "(()())";
        Solution sol = new Solution();
        Assert.assertArrayEquals(new int[]{0,1,1,1,1,0}, sol.maxDepthAfterSplit(seq));
    }

    @Test
    public void test2(){
        String seq = "()(())()";
        Solution sol = new Solution();
        Assert.assertArrayEquals(new int[]{0,0,0,1,1,0,1,1}, sol.maxDepthAfterSplit(seq));
    }

    @Test
    public void test3(){
        String seq = "(((()))((())))";
        Solution sol = new Solution();
        Assert.assertArrayEquals(new int[]{0,0,1,1,0,0,1,0,0,1,0,0,1,1}, sol.maxDepthAfterSplit(seq));
    }
}
