package zy.leetcode.queue.solution232;

import java.util.Stack;

/**
 * Created by kaiser_zhao on 13/08/2019.
 */
public class MyQueue {
    private Stack<Integer> stack = null;
    private boolean afterRotate = false;

    public static void main(String...strings){
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.peek();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
    }


    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    private void rotate(){
        Stack<Integer> tmp = new Stack<>();
        while(!stack.empty()){
            tmp.push(stack.pop());
        }
        stack = tmp;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(afterRotate){
            rotate();
            afterRotate = false;
        }
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!afterRotate){
            rotate();
            afterRotate = true;
        }
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!afterRotate){
            rotate();
            afterRotate = true;
        }
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}
