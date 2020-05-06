package zy.leetcode.sortandsearch.solution69;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }else if(x<=2){
            return 1;
        }
        int left = 2;
        int right = x/2;

        while(left - right <-1 || left -right > 1){
            left = (left+right)/2;
            right = x/left;
        }

        return Math.min(left, right);
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.mySqrt(8));
    }
}
