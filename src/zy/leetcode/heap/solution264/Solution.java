package zy.leetcode.heap.solution264;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    private static Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
        return u.ugly[n-1];
    }

    private static class Ugly{
        public int[] ugly = new int[1690];
        public Ugly(){
            PriorityQueue<Long> pq = new PriorityQueue<>();
            Set<Long> seen = new HashSet<>();
            pq.offer(1L);
            seen.add(1L);
            int[] primes = {2,3,5};
            long cur = 0L;
            long newCur = 0L;
            for(int i = 0; i < ugly.length; i++){
                cur = pq.poll();
                ugly[i] = (int)cur;
                for(int prime : primes){
                    newCur = cur * prime;
                    if(!seen.contains(newCur)){
                        pq.offer(newCur);
                        seen.add(newCur);
                    }
                }
            }
        }
    }

    @Test
    public void test(){
        Solution sol = new Solution();
        Assert.assertEquals(12, sol.nthUglyNumber(10));
    }
}
