package zy.leetcode.queue.solution225;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by kaiser_zhao on 2019/10/30.
 */
public class MyStack2 {
    public static void main(String...strings){
        MyStack2 myStack = new MyStack2();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    // there is only one item in q1
    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyStack2() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int top = q1.poll();
        while(q2.size() > 1){
            q1.add(q2.poll());
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;

        return top;
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
