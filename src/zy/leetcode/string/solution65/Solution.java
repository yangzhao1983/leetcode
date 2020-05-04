package zy.leetcode.string.solution65;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public boolean isNumber(String s) {
        boolean started = false;
        boolean eExist = false;
        boolean eEnd = true;
        boolean pointedLeft = false;
        boolean pointedRight = false;
        boolean pointed = false;
        char cur;
        char pre = ' ';

        for(int i = 0; i < s.length(); i++){
            cur = s.charAt(i);
            if(cur == 'e'){
                if(eExist){
                    return false;
                }else if((pre < '0' || pre > '9') && pre!='.'){
                    return false;
                }else if(pointed && !pointedLeft && !pointedRight){
                    return false;
                }
                eEnd = false;
                eExist = true;
            }else if(cur == '+' || cur == '-'){
                if(started && pre!='e'){
                    return false;
                }
            }else if (cur == '.'){
                if(pre >= '0' && pre <= '9'){
                    pointedLeft = true;
                }

                if (eExist){
                    return false;
                } else if(pointed){
                    return false;
                }
                pointed = true;
            }else if((cur < '0' || cur > '9' )&& (cur !=' ')){
                return false;
            }else if (cur != ' ' && pre == ' ' && started){
                return false;
            }

            if(cur != ' '){
                if(!started) started = true;
            }

            if(cur >= '0' && cur <= '9'){
                if(eExist && !eEnd){
                    eEnd = true;
                }
                if(pointed){
                    pointedRight = true;
                }
            }

            pre = cur;

        }
        return eEnd && started && ( pointed ? (pointedLeft || pointedRight):true);
    }

//    "0" => true
//            " 0.1 " => true
//            "abc" => false
//            "1 a" => false
//            "2e10" => true
//            " -90e3   " => true

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isNumber("0"));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber("abc"));
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber("1 a"));
    }

    @Test
    public void test4(){
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isNumber("2e10"));
    }

    @Test
    public void test5(){
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isNumber(" -90e3   "));
    }

    //            " 1e" => false
//            "e3" => false
//            " 6e-1" => true
    @Test
    public void test6(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber(" 1e"));
    }

    @Test
    public void test7(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber(" e3"));
    }

    @Test
    public void test8(){
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isNumber(" 6e-1"));
    }

    //            " 99e2.5 " => false
//            "53.5e93" => true
//            " --6 " => false
    @Test
    public void test9(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber("  99e2.5 "));
    }

    @Test
    public void test10(){
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isNumber("53.5e93"));
    }

    @Test
    public void test11(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber(" --6 "));
    }

    //            "-+3" => false
//            "95a54e53" => false
    @Test
    public void test12(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber("-+3"));
    }

    @Test
    public void test13(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber("95a54e53"));
    }

    @Test
    public void test14(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber(" "));
    }

    @Test
    public void test15(){
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isNumber(".1"));
    }

    @Test
    public void test16(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber(".e1"));
    }

    @Test
    public void test17(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber("..2"));
    }

    @Test
    public void test18(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber(". 1"));
    }

    @Test
    public void test19(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber(". 1"));
    }

    @Test
    public void test20(){
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isNumber(".1."));
    }

    @Test
    public void test21(){
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isNumber("46.e3"));
    }
}
