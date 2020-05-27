package zy.leetcode.array.solution974;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {
    /**
     * 1. pre sum
     * 2. for each pre sum, get mod, update map, key:mod, val: count
     * 3. combination
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        int[] preSum = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < A.length; i++){
            preSum[i] = (((i==0?0:preSum[i-1]) + A[i]) % K + K)%K;
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) +1);
        }
        int ans = 0;
        for(int val : map.values()){
            ans += (val * (val-1))/2;
        }
        return ans;
    }

    @Test
    public void test1(){
        int[] A= {4,5,0,-2,-3,1};
        Solution sol = new Solution();
        Assert.assertEquals(7, sol.subarraysDivByK(A, 5));
    }
}
