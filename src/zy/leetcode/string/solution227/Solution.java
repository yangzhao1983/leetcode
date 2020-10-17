package zy.leetcode.string.solution227;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class Solution {
    public int calculate(String s) {
        // trim the string
        // for each char
        // 1. '', skip
        // 2. number, pre char * 10 + number
        // 3. * or /, if this is the first op, set preOp
        //            else, if preOp is * or /, do the operation, reset preOp
        // 4. + or -, if this the first op, set preOp
        //            else, do preOp, reset preOp
        if(s==null || s.length()==0) return 0;

        LinkedList<Character> ops = new LinkedList<>();
        LinkedList<Integer> operand = new LinkedList<>();
        int num = 0;
        boolean isFirstOp = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else {
                operand.push(num);
                num = 0;
                if (isFirstOp) {
                    ops.push(c);
                    isFirstOp = false;
                }else{
                    char preOp = ops.peek();
                    if( c == '+' || c == '-'){
                        int second = operand.pop();
                        int first = operand.pop();
                        operand.push(doOp(first,second, preOp));
                        ops.pop();
                        if(!ops.isEmpty()){
                            second = operand.pop();
                            first = operand.pop();
                            operand.push(doOp(first, second, ops.pop()));
                        }
                    }else{
                        if(preOp == '*' || preOp == '/'){
                            int second = operand.pop();
                            int first = operand.pop();
                            operand.push(doOp(first,second, preOp));
                            ops.pop();
                        }
                    }
                    ops.push(c);
                }
            }
        }
        operand.push(num);
        while(!ops.isEmpty()){
            int second = operand.pop();
            int first = operand.pop();
            operand.push(doOp(first, second, ops.pop()));
        }

        return operand.pop();
    }

    private int doOp(int first, int second, char op){
        if(op == '+'){
            return first + second;
        }else if(op == '-'){
            return first - second;
        }else if(op == '*'){
            return first * second;
        }else{
            return first/second;
        }
    }

    @Test
    public void test1(){
        String s = "3+2*2";
        Solution sol = new Solution();
        Assert.assertEquals(7, sol.calculate(s));
    }

    @Test
    public void test2(){
        String s = "14-3/2";
        Solution sol = new Solution();
        Assert.assertEquals(13, sol.calculate(s));
    }

    @Test
    public void test3(){
        String s = "1*2-3/4+5*6-7*8+9/10";
        Solution sol = new Solution();
        Assert.assertEquals(-24, sol.calculate(s));
    }

}

