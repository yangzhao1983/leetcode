package zy.basics.col;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by kaiser_zhao on 2019/11/5.
 */
public class PQueueComparator {

    public static void main(String...strings){
        test3();
    }

    private static void test1(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(2);
        pq.add(1);

        // first debug point
        System.out.println(pq.peek());
        pq.poll();
        // second debug point
        System.out.println(pq.peek());
    }

    private static void test2(){
        PriorityQueue<PQItem> pq = new PriorityQueue<>();
        pq.add(new PQItem(3));
        pq.add(new PQItem(2));
        pq.add(new PQItem(1));

        System.out.println(pq.peek());
        pq.poll();
        System.out.println(pq.peek());
    }

    private static void test3(){
        PriorityQueue<PQItemNonSortable> pq = new PriorityQueue<>(new Comparator<PQItemNonSortable>() {
            @Override
            public int compare(PQItemNonSortable o1, PQItemNonSortable o2) {
                return o1.getVal() - o2.getVal();
            }
        });
        pq.add(new PQItemNonSortable(3));
        pq.add(new PQItemNonSortable(2));
        pq.add(new PQItemNonSortable(1));

        System.out.println(pq.peek());
        pq.poll();
        System.out.println(pq.peek());
    }
}

class PQItemNonSortable{
    @Override
    public String toString() {
        return Integer.toString(this.getVal());
    }

    private int val = 0;
    public PQItemNonSortable(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

class PQItem implements Comparable<PQItem>{

    @Override
    public String toString() {
        return Integer.toString(this.getVal());
    }

    @Override
    public int compareTo(PQItem o) {
        return this.getVal() - o.getVal();
    }

    private int val = 0;
    public PQItem(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
