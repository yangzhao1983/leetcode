package zy.leetcode.stack.solution394;

import com.sun.org.apache.bcel.internal.generic.FSUB;
import sun.tools.jstat.Jstat;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);
            if(isDigit(curChar)){
                String str = s.substring(i, i+1);
                if(!stack.isEmpty() && isDigit(stack.peek().charAt(0))){
                    str = stack.pop() + str;
                }
                stack.push(str);
            }else if(isLetter(curChar)){
                String str = s.substring(i, i+1);

                if(!stack.isEmpty() && isLetter(stack.peek().charAt(0))){
                    str = stack.pop() + s.substring(i, i+1);
                }else if(!stack.isEmpty() && isDigit(stack.peek().charAt(0))){
                    int times = getNumber(stack.pop());
                    String single = str;
                    while(times > 1){
                        str = str + single;
                        times--;
                    }
                }
                stack.push(str);
            }else if(curChar == '['){
                stack.push(s.substring(i,i+1));
            }else{
                // pop
                String surrounded = "";

                while(!"[".equals(stack.peek())){
                    surrounded = stack.pop() + surrounded;
                }

                // pop "["
                stack.pop();

                // digit
                int times = getNumber(stack.pop());
                String single = surrounded;
                while(times > 1){
                    surrounded = surrounded + single;
                    times--;
                }
                if(!stack.isEmpty() && isLetter(stack.peek().charAt(0))){
                    surrounded = stack.pop() + surrounded;
                }
                stack.push(surrounded);
            }
        }

        String ans = "";
        while(!stack.isEmpty()){
            ans = stack.pop() + ans;
        }

        return ans;
    }

    private int getNumber(String digits){
        return Integer.parseInt(digits);
    }

    private boolean isDigit(char c){
        if(c >= '0' && c<= '9'){
            return true;
        }else{
            return false;
        }
    }

    private boolean isLetter(char c){
        if((c >= 'a' && c<= 'z')||(c >='A' && c <= 'Z')){
            return true;
        }else{
            return false;
        }
    }
}
