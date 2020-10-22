package zy.leetcode.array.solution495;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * A[i]
     * cur_end = A[i] + duration - 1
     * end < A[i]
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0) return 0;
        int ans = 0;
        int start = timeSeries[0], end = duration + timeSeries[0] - 1;
        for(int i = 1; i < timeSeries.length; i++){
            if(end >= timeSeries[i]) end = Math.max(end, timeSeries[i] + duration - 1);
            else{
                ans += (end - start)+1;
                start = timeSeries[i];
                end = duration + timeSeries[i] - 1;
            }
        }
        ans += end - start + 1;
        return ans;
    }

    @Test
    public void test1(){
        int[] timeSeries = {1,4};
        Solution sol = new Solution();
        Assert.assertEquals(4, sol.findPoisonedDuration(timeSeries, 2));
    }
}
