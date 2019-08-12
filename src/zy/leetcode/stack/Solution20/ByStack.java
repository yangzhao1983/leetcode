package zy.leetcode.stack.Solution20;

import java.util.*;

/**
 * Created by kaiser_zhao on 12/08/2019.
 */
public class ByStack {

    public static void main(String ...strings){
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> matched = new HashMap<>();
        matched.put(')','(');
        matched.put('}','{');
        matched.put(']','[');
        Stack<Character> stack = new Stack();
        Set<Character> left = new HashSet<>(Arrays.asList('(','{','['));

        for(char c : s.toCharArray()){
            if(left.contains(c)){
                stack.push(c);
            }else{
                if(!stack.empty() && matched.get(c).equals(stack.peek())){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
