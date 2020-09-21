package zy.leetcode.bit.solution190;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++){
            int masked = mask & n;
            n >>= 1;
            ans = (ans << 1) + masked;
        }
        return ans;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int n = 43261596;
        Assert.assertEquals(964176192, sol.reverseBits(n));
    }
}
