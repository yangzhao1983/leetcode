package zy.leetcode.hash.solution454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A == null || A.length == 0) return 0;

        int ans = 0;
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = 0 - (A[i] + B[j]);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans += map.getOrDefault(C[i] + D[j], 0);
            }
        }
        return ans;
    }
}
