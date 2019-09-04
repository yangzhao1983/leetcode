package zy.leetcode.stack.solution402;

import java.util.Stack;

/**
 * Created by kaiser_zhao on 2019/9/4.
 */
public class ByStack {

    public static void main(String...strings){
        System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10200",1));
        System.out.println(removeKdigits("10",2));
        System.out.println(removeKdigits("9",1));
    }

    public static String removeKdigits(String num, int k) {
        // margin check
        if(k==0){
            return num;
        }

        Stack<Character> charStack = new Stack<>();
        charStack.push(num.charAt(0));
        for(int index = 1; index < num.length(); index++){
            if(num.charAt(index) == '0' && charStack.size() <= k){
                k -= charStack.size();
                while(!charStack.isEmpty()){
                    charStack.pop();
                }
                while(index<num.length() && num.charAt(index)=='0'){
                    index++;
                }
            }

            if(index == num.length()){
                break;
            }

            while(index < num.length() && charStack.size()>0 && k >0 && num.charAt(index) < charStack.peek()){
                k--;
                charStack.pop();
            }

            charStack.push(num.charAt(index));
        }

        // last check
        while(k>0 && !charStack.isEmpty()){
            k--;
            charStack.pop();
        }

        String rel = "";
        while(!charStack.isEmpty()){
            rel = charStack.pop() + rel;
        }
        if(rel == ""){
            rel = "0";
        }

        return  rel;
    }
}
