package zy.leetcode;

import java.util.Stack;

/**
 * Created by kaiser_zhao on 2018/10/28.
 */
public class Solution20 {
    public static void main(String...strings){
        System.out.println(isValid("]"));
        System.out.println(isValid(null));
        System.out.println(isValid(""));
        System.out.println(isValid("a"));
        System.out.println(isValid("{a"));
        System.out.println(isValid("{["));
        System.out.println(isValid("{[("));
        System.out.println(isValid("{[(as)]}"));
        System.out.println(isValid("{g[(as)]a}"));
        System.out.println(isValid("{g[(as)a}"));
        System.out.println(isValid("{g(as)]a}"));
    }

    public static boolean isValid(String s) {
        if(s==null || s.length()==0){
            return true;
        }
        Stack<String> parentheses = new Stack<>();
        for(int i = 0; i<s.length();i++){
            String c = s.substring(i,i+1);
            switch (c){
                case "{":
                case "[":
                case "(": parentheses.push(c); break;
                case "}":  if (parentheses.empty() || !parentheses.pop().equals("{")){return false;} break;
                case "]": if (parentheses.empty() || !parentheses.pop().equals("[")){return false;} break;
                case ")": if (parentheses.empty() || !parentheses.pop().equals("(")){return false;} break;
                default:
            }
        }
        return parentheses.empty();
    }
}
