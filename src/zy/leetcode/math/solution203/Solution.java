package zy.leetcode.math.solution203;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int countPrimes(int n) {
        int ans = 0;
        for(int i = 2; i <= n; i++){
            if(isPrime(i)) ans++;
        }
        return ans;
    }

    private boolean isPrime(int n){
        if(n == 2 || n==3) return true;
        int fac = n/2;
        for(int i = 2; i <= fac; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(4,sol.countPrimes(10));
    }
}
