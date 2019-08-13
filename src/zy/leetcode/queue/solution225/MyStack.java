package zy.leetcode.queue.solution225;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by kaiser_zhao on 13/08/2019.
 */
public class MyStack {

    public static void main(String...strings){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.top());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.empty());
    }

    private Queue<Integer> q1 = null;

    public MyStack(){
        q1 = new ArrayDeque<Integer>();
    }
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return doReturnFirst(true);
    }

    /**
     * put all of the items in one Q to the other Q, except the last one
     * if need to remove the last one, remove it
     * else also put it the the other Q.
     *
     * @param toRemove
     * @return
     */
    private int doReturnFirst(boolean toRemove){
        Queue<Integer> tmp = new ArrayDeque<Integer>();

        int len = q1.size()-1;
        for(int i =0 ; i < len; i++){
            tmp.add(q1.poll());
        }

        int ans = 0;

        if(toRemove){
            ans =  q1.poll();
        }else{
            ans = q1.poll();
            tmp.add(ans);
        }

        q1 = tmp;

        return ans;
    }

    /** Get the top element. */
    public int top() {
        return doReturnFirst(false);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
