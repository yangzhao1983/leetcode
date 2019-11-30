package zy.leetcode.queue.solution239;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kaiser_zhao on 2019/11/5.
 */
public class SolutionWithComments {

    public static void main(String...strings){
        testcase1();
    }

    private static void testcase1(){
        int[] nums = {1,3,-1,-3,5,3,6,7};

        for(int i : maxSlidingWindow(nums, 3) ){
            System.out.println(i);
        }
    }

    /**
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<List<Integer>> numsQueue = new LinkedList<>();
        int[] ans = new int[nums.length + 1- k];
        int ansIndex = 0;
        for(int i = 0; i< nums.length; i++){

            if(!numsQueue.isEmpty() && numsQueue.peekLast().get(0) > nums[i]){
                List<Integer> tail = numsQueue.peekLast();
                tail.remove(1);
                tail.add(i);
            }else{
                List<Integer> item = new ArrayList<>();
                item.add(nums[i]);
                item.add(i);
                numsQueue.add(item);
            }

            if(i - numsQueue.peekFirst().get(1) + 1 == k){
                ans[ansIndex++] = numsQueue.peekLast().get(0);
                numsQueue.pollFirst();
            }
        }

        return ans;
    }
}
