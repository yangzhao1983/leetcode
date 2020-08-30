package zy.leetcode.string.solution557;

import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
        String ans = "";
        Stack<String> stack = new Stack<>();
        for(int i = 0; i <= s.length(); i++){
            if(i==s.length() || s.substring(i,i+1).equals(" ")){
                while(!stack.isEmpty()){
                    ans = ans + stack.pop();
                }
                if(i<s.length()-1) ans = ans + " ";
            }else stack.push(s.substring(i,i+1));
        }
        return ans;
    }
}
