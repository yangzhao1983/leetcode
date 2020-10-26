package zy.leetcode.math.solution233;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * 9：1
     * 99：10 * 1 + 10 = 20
     * 999：10 * 20 + 100 = 300
     * a[i]: num of 9 = i, 10 * a[i-1] + power(10, i-1)
     *
     * n = b[0] + b[1] * 10 + b[2] * power(10, 2) + .. b[i] * power(10, i)
     * a[i]
     * b[i] = 1: b[0] + b[1] * 10 + b[2] * power(10, 2) + .. b[i-1] * power(10, i-1) + 1
     * b[i] > 1: a[i] + a[i] + 10..0 + num[i-1]
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        int size = 0;
        int temp = n;
        List<Integer> bl = new LinkedList<>();
        while(temp > 0){
            bl.add(temp%10);
            temp /= 10;
        }
        size = bl.size();
        int[] a = new int[size];

        a[0] = 1;
        int ten = 1;
        for(int i = 1; i < size; i++){
            ten *= 10;
            a[i] = 10 * a[i-1] + ten;
        }

        int cum = bl.get(0);
        int b = cum == 0 ? 0 :1;
        ten = 1;
        for(int i = 1; i < size; i++){
            int cur = bl.get(i);
            ten *=10;

            if (cur > 0) {
                if(cur == 1){
                    b += a[i-1] + (cum + 1);
                }else{
                    b += cur*a[i-1] + ten;
                }
            }
            cum = cur * ten + cum;
        }
        return b;
    }

    @Test
    public void test(){
        Solution sol = new Solution();
        Assert.assertEquals(20, sol.countDigitOne(99));
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(21, sol.countDigitOne(100));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals(259, sol.countDigitOne(789));
    }
}
