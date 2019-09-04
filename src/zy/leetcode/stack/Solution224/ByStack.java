package zy.leetcode.stack.Solution224;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by kaiser_zhao on 12/08/2019.
 */
public class ByStack {

    public static void main(String...strings){
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate("2-1+2"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("(1)"));
        System.out.println(calculate("2147483647"));
    }

    public static int calculate(String s) {
        Map<Character, Integer> rank = new HashMap<Character, Integer>();
        rank.put('+', 1);
        rank.put('-', 1);
        rank.put('(', 100);
        rank.put(')', -100);

        Stack<Integer> numsStack = new Stack<>();
        Stack<Character> opsStack = new Stack<>();
        int curNums = 0;
        char[] cs = s.toCharArray();
        // go into stack
        boolean numStart = false;
        for(char c : s.toCharArray()){
            // if space, skip
            if(c==' '){
                continue;
            }
            // if number, if num start = false, start = true
            //            else numsStack pop, poped * 10 + num
            if(c >='0' && c<='9'){
                if(numStart == false){
                    numStart = true;
                    numsStack.push(c-'0');
                }else{
                    int high = numsStack.pop();
                    numsStack.push(high * 10 + c-'0');
                }
            }
            // else start = false
            //      if (, put into stack
            //      if + or - put into stack
            //      if ), start to get char (+, -, num) out of stacks. after all get ( out of stack
            else{
                numStart = false;
                if(c=='('){
                    opsStack.push(c);
                }else if(c == '+' || c=='-'){
                    if(!opsStack.isEmpty()  && rank.get(c) >= rank.get(opsStack.peek())){
                        getCharOutOfStacks(numsStack, opsStack);
                    }
                    opsStack.push(c);
                }else{
                    if(opsStack.peek() != '('){
                        getCharOutOfStacks(numsStack, opsStack);
                    }
                    opsStack.pop();
                }
            }
        }

        // get char (+, -, num) out of stacks
        if (!opsStack.isEmpty()) {
            getCharOutOfStacks(numsStack, opsStack);
        }
        return numsStack.pop();
    }

    /**
     * opsStack pop +,-,
     *   pop two char from numsStack, operate them, put rel back to numsStack
     */
    private static void getCharOutOfStacks(Stack<Integer> numsStack, Stack<Character> opsStack){

        int optRight = numsStack.pop();
        int optLeft = numsStack.pop();
        int sign = opsStack.pop() == '+' ? 1:-1;
        numsStack.push(optLeft + sign * optRight);
    }
}
