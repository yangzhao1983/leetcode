package zy.leetcode.stack.solution402;

import java.util.Stack;

/**
 * Created by kaiser_zhao on 2019/10/25.
 */
public class Enhanced {

    public static void main(String...strings){
        System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10200",1));
        System.out.println(removeKdigits("10",2));
        System.out.println(removeKdigits("9",1));
        System.out.println(removeKdigits("112",1));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Integer> nums = new Stack<>();
        // loop
        // if stack is empty, if num is 0, continue; else push it to stack
        // if num >= stack top, push it to stack
        // if num < stack, stack pop, k--
        //      if k == 0, break
        int i = 0;
        while(i<num.length()){
            int numInt = num.charAt(i) - '0';
            if(nums.isEmpty() && numInt == 0){
                i++;
                continue;
            } else if (!nums.isEmpty() && numInt < nums.peek() && k>0){
                nums.pop();
                k--;
            }else{
                nums.push(numInt);
                i++;
            }
        }


        // until k == 0 || stack is empty
        // stack.pop
        while(k-->0 && !nums.isEmpty()){
            nums.pop();

        }

        // calculate nums in stack
        String ans = "";
        while(!nums.isEmpty()){
            ans = "" + nums.pop() + ans;
        }
        return ans == ""? "0" : ans;
    }

}
