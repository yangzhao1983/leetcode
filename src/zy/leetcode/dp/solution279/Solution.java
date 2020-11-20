package zy.leetcode.dp.solution279;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSquares(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i = 1; i <= n; i++){
            int root = 1;
            int rootSqr = root * root;
            int min = Integer.MAX_VALUE;
            while(rootSqr <= i){
                if(map.get(i-rootSqr) < Integer.MAX_VALUE){
                    min = Math.min(min, map.get(i-rootSqr) + 1);
                }
                root ++;
                rootSqr = root * root;
            }
            map.put(i, min);
        }
        return map.get(n);
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(3, sol.numSquares(12));
    }
}
