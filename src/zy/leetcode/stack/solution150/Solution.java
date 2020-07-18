package zy.leetcode.stack.solution150;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)return 0;

        Stack<String> stack = new Stack<>();
        Set<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");

        for(String str : tokens){
            if(ops.contains(str)){
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                int rel = 0;
                switch (str){
                    case "+": rel = op1 + op2;break;
                    case "-": rel = op1 - op2;break;
                    case "*": rel = op1 * op2;break;
                    case "/": rel = op1/op2;break;
                }
                stack.push(Integer.toString(rel));
            }else stack.add(str);
        }
        return Integer.parseInt(stack.pop());
    }
}
