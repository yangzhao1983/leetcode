package zy.leetcode.queue.offer09;

import java.util.Stack;

public class CQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public CQueue() {
    }

    /**
     * 1,2
     * 1,2,3
     *
     *
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    /**
     * 1,2,3
     * -> 3,2,1
     *
     * remove 1
     *
     * 3,2
     * -> 2,3
     *
     * @return
     */
    public int deleteHead() {
        if(stack1.isEmpty()) return -1;
        while(!stack1.isEmpty()) stack2.push(stack1.pop());
        int rel = stack2.pop();
        while(!stack2.isEmpty()) stack1.push(stack2.pop());
        return rel;
    }
}
