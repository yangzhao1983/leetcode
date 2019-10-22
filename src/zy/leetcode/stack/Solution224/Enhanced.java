package zy.leetcode.stack.Solution224;

import java.util.Stack;

/**
 * Created by kaiser_zhao on 2019/10/22.
 */
public class Enhanced {
    public static void main(String...strings){
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate("2-1+2"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("(1)"));
        System.out.println(calculate("2147483647"));
    }

    public static int calculate(String s) {

        Stack<Character> stackSigns = new Stack<>();
        Stack<Integer> stackNums = new Stack<>();

        boolean isNumStart = false;

        for(char c:s.toCharArray()){
            // skip space
            if(c == ' '){
                continue;
            }

            // if 0-9
            if(c>='0' && c<='9'){
                // if the first non-space char before current char is not number
                if(!isNumStart){
                    isNumStart = true;
                    stackNums.push(c - '0');
                }
                // if the first non-space char before current char is number
                else{
                    int highPos = stackNums.pop();
                    stackNums.push(c - '0' + highPos * 10);
                }
            }
            // (, ), -, or +
            else{
                // number should reach end.
                isNumStart = false;

                // put ( into S
                if (c == '('){
                    stackSigns.push(c);
                }else if (c==')'){
                    char sign = stackSigns.pop();
                    if(sign != '('){
                        stackNums.push(calRel(sign, stackNums));
                        // ( out
                        stackSigns.pop();
                    }
                }else{
                    // + -
                    if(stackSigns.isEmpty() || stackSigns.peek() == '('){
                        stackSigns.push(c);
                    }else{
                        char sign = stackSigns.pop();
                        stackNums.push(calRel(sign, stackNums));
                        stackSigns.push(c);
                    }
                }
            }
        }
        int ans = 0;
        if(!stackSigns.isEmpty()){
            char sign = stackSigns.pop();
            ans = calRel(sign, stackNums);
        }else{
            ans = stackNums.pop();
        }
        return ans;
    }

    private static int calRel(char sign, Stack<Integer> nums){

        int rightOp = nums.pop();
        int leftOp = nums.pop();

        if(sign =='+' ){
            return leftOp + rightOp;
        }else{
            return leftOp - rightOp;
        }
    }
}
