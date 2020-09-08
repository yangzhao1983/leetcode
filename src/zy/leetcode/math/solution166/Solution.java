package zy.leetcode.math.solution166;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {

        // sign
        // to long

        // n/d, XX.
        // n/d, get remainder.
        // remainder = remainder * 10
        // index = 0

        // remainder = 0, return
        // if exists, ()
        // if < d, +"0", remainder = remainder * 10, index ++
        // remainder/d, + "d", <remainder = index>, remainder = r * 10
        if(numerator == 0) return "0";
        int sign = 1;
        if(numerator < 0 ^ denominator <0) sign = -1;
        long lN = Math.abs(Long.valueOf(numerator));;
        long lD = Math.abs(Long.valueOf(denominator));;

        long q = lN/lD;
        long r = lN%lD;
        String ans = (sign < 0 ? "-" : "") + String.valueOf(q);
        if(r==0) return ans;
        else ans += ".";
        r = r * 10;
        Map<Long, Integer> map = new HashMap<>();

        int index = ans.length();
        while(true){
            if(r==0) return ans;
            if(map.containsKey(r)){
                String cycle = ans.substring(map.get(r));
                return ans.substring(0, map.get(r)) + "(" + cycle + ")";
            }
            if(r < lD){
                ans += "0";
                map.put(r, index++);
                r = r * 10;
            }else{
                q = r/lD;
                ans += String.valueOf(q);
                map.put(r, index++);
                r = r%lD * 10;
            }
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals("0.5", sol.fractionToDecimal(1,2));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals("2", sol.fractionToDecimal(2,1));
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        Assert.assertEquals("0.(6)", sol.fractionToDecimal(2,3));
    }

    @Test
    public void test4(){
        Solution sol = new Solution();
        Assert.assertEquals("0.(012)", sol.fractionToDecimal(4,333));
    }

    @Test
    public void test5(){
        Solution sol = new Solution();
        Assert.assertEquals("0.1(6)", sol.fractionToDecimal(1,6));
    }

    @Test
    public void test6(){
        Solution sol = new Solution();
        Assert.assertEquals("0.0(1)", sol.fractionToDecimal(1,90));
    }

    @Test
    public void test7(){
        Solution sol = new Solution();
        Assert.assertEquals("-6.25", sol.fractionToDecimal(-50,8));
    }

    @Test
    public void test8(){
        Solution sol = new Solution();
        Assert.assertEquals("-0.58(3)", sol.fractionToDecimal(7,-12));
    }
}
