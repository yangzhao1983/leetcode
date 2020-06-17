package zy.leetcode.array.solution1014;

public class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0;
        int mi = A[0];

        for(int i = 1; i < A.length; i++){
            ans = Math.max(ans, A[i]-i + mi);
            mi = Math.max(mi, A[i] + i);
        }
        return ans;
    }
}
