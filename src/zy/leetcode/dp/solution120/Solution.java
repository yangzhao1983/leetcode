package zy.leetcode.dp.solution120;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int[] dp = new int[triangle.size() ];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < dp.length; i++){
            int lastLeft = dp[0];
            dp[i] = triangle.get(i).get(i) + dp[i-1];
            dp[0] = lastLeft + triangle.get(i).get(0);
            for(int j = 1; j < i; j++){
                int lastCur = dp[j];
                int curVal = triangle.get(i).get(j);
                dp[j] = curVal + Math.min(lastLeft, dp[j]);
                lastLeft = lastCur;
            }
        }
        for(int i = 0; i < dp.length; i++){
            if(dp[i] < ans) ans = dp[i];
        }

        return ans;
    }
}
