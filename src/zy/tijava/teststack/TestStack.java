package zy.tijava.teststack;

import java.util.LinkedList;

/**
 * Created by kaiser_zhao on 13/04/2019.
 */
public class TestStack {
    public static void main(String...strings){
        MyStack<Character> ms = new MyStack<>();
        boolean isAdded = false;
        String s = "+U+n+c---+e+r+t---+a-+i+n+t+y---+-+r+u--+l+e+s--";
        for (char c : s.toCharArray()){
            if(isAdded){
                ms.push(c);
                isAdded = false;
            } else if (c == '+'){
                isAdded = true;
            } else if(c == '-'){
                System.out.println(ms.pop());
            }
        }
    }
}

class MyStack<E>{
    private LinkedList<E> storage = new LinkedList<E>();
    public void push(E e){
        storage.addFirst(e);
    }
    public E peek(){
        return storage.getFirst();
    }
    public E pop(){
        return storage.removeFirst();
    }

    public boolean empty(){
        return storage.isEmpty();
    }

    public String toString(){
        return storage.toString();
    }
}
