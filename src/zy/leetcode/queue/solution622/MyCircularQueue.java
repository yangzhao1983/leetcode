package zy.leetcode.queue.solution622;

public class MyCircularQueue {

    public static void main(String...strings){
        MyCircularQueue circularQueue = new MyCircularQueue(3);

        // return true
        System.out.println(circularQueue.enQueue(1));

        // return true
        System.out.println(circularQueue.enQueue(2));

        // return true
        System.out.println(circularQueue.enQueue(3));

        // return false, the queue is full
        System.out.println(circularQueue.enQueue(4));

        // return 3
        System.out.println(circularQueue.Rear());

        // return true
        System.out.println(circularQueue.isFull());

        // return true
        System.out.println(circularQueue.deQueue());

        // return true
        System.out.println(circularQueue.enQueue(4));

        // return 4
        System.out.println(circularQueue.Rear());
    }

    // 1. initial value is 0
    // 2. if one item is deleted, head++, if head == len, head==0.
    private int head = 0;

    // 1. initial value is 0
    // 2. If one item is added, tear++, if tear==len, tear ==0, value[tear] = item.
    private int rear = 0;

    // if (tear ==len - 1 and head ==0) or (tear = head - 1) =>full
    // if tear == head, empty

    private int[] datas;

    private int len = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        datas = new int[k+1];
        len = k + 1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.isFull()){
            return false;
        }else{
            datas[rear] = value;
            rear = (rear + 1)%len;
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(this.isEmpty()){
            return false;
        }else{
            head = (head + 1)%len;
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(this.isEmpty()){
            return -1;
        }else{
            return datas[head];
        }
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(this.isEmpty()){
            return -1;
        }else{
            return datas[(rear - 1 + len)% len];
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == rear;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear + 1 )% len == head;
    }
}
