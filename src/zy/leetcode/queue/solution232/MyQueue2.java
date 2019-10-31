package zy.leetcode.queue.solution232;

import java.util.Stack;

/**
 * Created by kaiser_zhao on 2019/10/31.
 */
public class MyQueue2 {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue2() {

    }

    private int getItem(boolean removed){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        int top = 0;
        if(removed) {
            top = s2.pop();
        }else{
            top = s2.peek();
        }

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return top;
    }

    public static void main(String...strings){
        MyQueue2 obj = new MyQueue2();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.peek();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return  getItem(true);
    }

    /** Get the front element. */
    public int peek() {
        return  getItem(false);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
