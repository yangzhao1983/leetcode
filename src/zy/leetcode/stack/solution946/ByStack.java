package zy.leetcode.stack.solution946;

import java.util.Stack;

/**
 * Created by kaiser_zhao on 2019/10/30.
 */
public class ByStack {

    public static void main(String...strings){
        test1();
        test2();
    }

    private static void test1(){
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};

        System.out.println(validateStackSequences(pushed,popped));
    }

    private static void test2(){
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};

        System.out.println(validateStackSequences(pushed,popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || pushed.length < 2){
            return true;
        }

        Stack<Integer> nums = new Stack<>();
        int popped_i = 0;
        for(int push : pushed){
            nums.push(push);
            while(!nums.isEmpty() && popped[popped_i] == nums.peek()){
                popped_i++;
                nums.pop();
            }
        }

        return nums.isEmpty();
    }
}
