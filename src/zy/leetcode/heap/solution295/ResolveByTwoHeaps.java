package zy.leetcode.heap.solution295;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by kaiser_zhao on 2019/9/11.
 */
public class ResolveByTwoHeaps {

    public static void main(String...strings){
//        testcase1();
        testcase2();
    }

    private static void testcase1(){
        ResolveByTwoHeaps rbth = new ResolveByTwoHeaps();
        rbth.addNum(2);
        rbth.addNum(3);
        rbth.addNum(4);
        System.out.print(rbth.findMedian());
    }

    private static void testcase2(){
        ResolveByTwoHeaps rbth = new ResolveByTwoHeaps();
        rbth.addNum(2);
        rbth.addNum(3);
        System.out.print(rbth.findMedian());
    }

    private PriorityQueue<Integer> maxHeap;

    private PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public ResolveByTwoHeaps() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if(maxHeap.size() == minHeap.size()){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }else{
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())* 1.0/2;
        }else{
            return minHeap.peek();
        }
    }
}
