package zy.leetcode.math.solution60;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        if(n == 1){
            return "1";
        }

        int[] fac = getNFac(n);
        int a = k - 1;
        String ans = "";
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }

        for(int i = 0; i < n-1; i++){
            int num = a/fac[i];
            ans += nums.remove(num);
            a = a%fac[i];
        }

        return ans + nums.get(0);
    }

    private int[] getNFac(int n){
        int[] fac = new int[n-1];
        fac[n-2] = 1;
        for(int i = n-3; i >=0; i--){
            fac[i] = fac[i+1] * (n-i-1);
        }
        return fac;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals("213", sol.getPermutation(3,3));
    }
}
