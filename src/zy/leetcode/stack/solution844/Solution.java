package zy.leetcode.stack.solution844;

import java.util.Stack;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        return backspacing(S).equals(backspacing(T));
    }

    private String backspacing(String s){
        if(s==null) return "";
        Stack<String> stack = new Stack<>();
        String s1 = "";
        for(int i = 0; i <s.length();i++){
            String c = s.substring(i, i+1);
            if(c.equals("#")){
                if(!stack.isEmpty()) stack.pop();
            }else{
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            s1+=stack.pop();
        }
        return s1;
    }
}
