package zy.leetcode.stack.solution735;

import java.util.LinkedList;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() > 0) {
                    if(stack.peek() == Math.abs(asteroids[i])){
                        stack.pop();
                    }
                } else {
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
