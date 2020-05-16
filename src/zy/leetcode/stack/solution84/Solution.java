package zy.leetcode.stack.solution84;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){

            while(stack.peek()!=-1 && heights[stack.peek()] >= heights[i])
                maxArea = Math.max(heights[stack.pop()] * (i - stack.peek() - 1), maxArea);

            stack.push(i);
        }

        while(stack.peek()!=-1){
            maxArea = Math.max(heights[stack.pop()] * (heights.length - stack.peek() - 1), maxArea);
        }

        return maxArea;
    }

    @Test
    public void test1(){
        int[] heights = {2,1,5,6,2,3};
        Solution sol = new Solution();
        Assert.assertEquals(10, sol.largestRectangleArea(heights));
    }

    @Test
    public void test2(){
        int[] heights = {0,9};
        Solution sol = new Solution();
        Assert.assertEquals(9, sol.largestRectangleArea(heights));
    }

    @Test
    public void test3(){
        int[] heights = {1};
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.largestRectangleArea(heights));
    }
}
