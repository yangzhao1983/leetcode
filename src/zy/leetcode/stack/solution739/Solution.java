package zy.leetcode.stack.solution739;

import java.util.Stack;

public class Solution {
    /***
     * if a[i] <= a[stack.top], push a[i] to stack
     * else
     *  ans[top] = i - top, pop
     *
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        if(T==null || T.length == 0){
            return null;
        }

        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);

        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }
        return ans;
    }
}
