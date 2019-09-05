package zy.leetcode.queue.solution239;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kaiser_zhao on 2019/9/5.
 */
public class QueueSlideWindow {

    public static void main(String...strings){
        testcase2();
    }

    private static void testcase2(){
        int[] nums = {};

        for(int i : maxSlidingWindow(nums, 3) ){
            System.out.println(i);
        }
    }

    private static void testcase1(){
        int[] nums = {1,3,-1,-3,5,3,6,7};

        for(int i : maxSlidingWindow(nums, 3) ){
            System.out.println(i);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums==null || nums.length == 0){
            return new int[]{};
        }

        if(k==1){
            return nums;
        }

        int[] ans = new int[nums.length - k + 1];

        // deque to store the numbers
        LinkedList<List<Integer>> deque = new LinkedList<>();

        // arraylist [value, index], put this object to deque
        // initialize deque nums[0] -> deque
        List<Integer> zero = new ArrayList<>();
        zero.add(nums[0]);
        zero.add(0);
        deque.add(zero);

        // for nums[i],
        //      if head.index = i - k -1, get head.value.
        //      if head.index = i - k, remove head.
        // if nums[i] <= tail, input nums[i] to deque
        // else remove head, until nums[i] <= tail or deque is empty
        for(int i = 1; i < nums.length; i++){
            if(deque.getFirst().get(1) == i-k){
                deque.removeFirst();
            }
            while( !deque.isEmpty() && nums[i] > deque.getLast().get(0)){
                deque.removeLast();
            }
            List<Integer> cur = new ArrayList<>();
            cur.add(nums[i]);
            cur.add(i);
            deque.add(cur);

            if(i-k+1>=0){
                ans[i-k+1] = deque.getFirst().get(0);
            }
        }

        return ans;
    }
}
