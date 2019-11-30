package zy.tijava.teststack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kaiser_zhao on 21/04/2019.
 */
public class TestStackEvent {
    public static void main(String...strings){
        EventStack<Character> es = new EventStack<>();
        boolean isAdded = false;
        List<CharEvent> list = new ArrayList<>();
        String s = "+U+n+c---+e+r+t---+a-+i+n+t+y---+-+r+u--+l+e+s--";
        for (char c : s.toCharArray()){
            if(isAdded){
                list.add(EventFactory.getInstance(Operation.PLUS, c, es));
                isAdded = false;
            } else if (c == '+'){
                isAdded = true;
            } else if(c == '-'){
                list.add(EventFactory.getInstance(Operation.MINUS, c, es));
            }
        }
        for(CharEvent ce : list){
            ce.action();
        }
    }
}

// event: operation, if operation is plus, there is a character as operand. Access to event stack

interface CharEvent{
    void action();
}

class EventFactory{
    private static abstract class CommonEvent implements CharEvent{
        protected EventStack<Character> stack;

        public CommonEvent(EventStack<Character> stack){
            this.stack = stack;

        }
    }

    private static class MinusEvent extends CommonEvent{
        public MinusEvent(EventStack<Character> stack){
            super(stack);
        }
        public void action(){
            System.out.println(stack.pop());
        }
    }

    private static class PlusEvent extends CommonEvent{
        private Character c;
        public PlusEvent(EventStack<Character> stack, Character c){
            super(stack);
            this.c = c;
        }
        public void action(){
            stack.push(c);
        }
    }

    public static CharEvent getInstance(Operation operation, Character c, EventStack<Character> stack){
        if (operation.equals(Operation.MINUS)){
            return new MinusEvent(stack);
        }else{
            return new PlusEvent(stack, c);
        }
    }
}

enum Operation { PLUS, MINUS}

class EventStack<E>{
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