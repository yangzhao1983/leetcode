package zy.leetcode.dp.solution718;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int ans = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                if (dp[i][j] > ans) ans = dp[i][j];
            }
        }
        return ans;
    }

    @Test
    public void test1() {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        Solution sol = new Solution();
        Assert.assertEquals(3, sol.findLength(A, B));
    }
}
