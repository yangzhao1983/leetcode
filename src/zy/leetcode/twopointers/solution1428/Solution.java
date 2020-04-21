package zy.leetcode.twopointers.solution1428;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    // start, first, last, end: last num after last which is even
    // fist - start + 1
    // *
    // end - last + 1
    //
    // start = first++, first = next (queue), last = end++, find end
    public int numberOfSubarrays(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        int start = 0;
        int end = 0;
        int odd = 0;
        int count = 0;
        int ans = 0;

        while(count < k && odd < nums.length){
            while(odd < nums.length && nums[odd]%2==0) odd++;
            if(odd < nums.length){
                q.addLast(odd);
                count++;
            }
            odd++;
        }

        if(q.size() < k){
            return 0;
        }
        int last = 0;
        int first = 0;
        while(last < nums.length){
            if (!q.isEmpty()){
                last = q.getLast();
                first = q.pollFirst();
            }else{
                first++;
                last = first;
            }
            end = findEnd(last, nums);
            ans += (first - start + 1) * (end - last + 1);
            start = first+1;
            last = end+1;
            q.addLast(last);
        }

        return ans;
    }

    /**
     * last num after last which is even
     */
    private int findEnd(int curLast, int[] nums){
        int pointer = curLast+1;
        while(pointer < nums.length && nums[pointer]%2==0){
            pointer++;
        }
        return --pointer;
    }

    @Test
    public void test1(){
        int[] nums = {1,1,2,1,1};
        int k = 3;
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.numberOfSubarrays(nums,k));
    }

    @Test
    public void test2(){
        int[] nums = {2,4,6};
        int k = 1;
        Solution sol = new Solution();
        Assert.assertEquals(0, sol.numberOfSubarrays(nums,k));
    }

    @Test
    public void test3(){
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        Solution sol = new Solution();
        Assert.assertEquals(16, sol.numberOfSubarrays(nums,k));
    }

    @Test
    public void test4(){
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 0;
        Solution sol = new Solution();
        Assert.assertEquals(15, sol.numberOfSubarrays(nums,k));
    }
}
