package zy.leetcode.stack.solution402sec;

import java.util.Stack;

public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<String > stack = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            String cur = num.substring(i, i+1);
            while(!stack.isEmpty() && cur.compareTo(stack.peek()) < 0 && k>0){
                stack.pop();
                k--;
            }
            if(stack.isEmpty() && cur.equals("0")){
                continue;
            }else{
                stack.push(cur);
            }
        }
        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        if(stack.isEmpty()) return "0";

        String ans = "";
        while(!stack.isEmpty()){
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
