package zy.leetcode.design.solution155;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MinStack {

    private Stack<Integer> stack;
    private List<Integer> sorted;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        sorted = new ArrayList<>();
    }

    public void push(int x) {
        stack.push(x);
        int i = 0;
        while (i < sorted.size() && sorted.get(i) > x) i++;
        sorted.add(i, x);
    }

    public void pop() {
        int target = stack.pop();
        Iterator<Integer> iterator = sorted.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == target) {
                iterator.remove();
                break;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return sorted.get(sorted.size() - 1);
    }

    @Test
    public void test1() {
        MinStack ms = new MinStack();
        ms.push(0);
        ms.push(1);
        ms.push(0);
        Assert.assertEquals(0, ms.getMin());
        ms.pop();
        Assert.assertEquals(0, ms.getMin());
    }
}
