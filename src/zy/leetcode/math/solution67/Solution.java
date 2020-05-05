package zy.leetcode.math.solution67;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    // step1: k = min(a_len, b_len)
    // loop[a_len-k,a_len), [b_len-k, b_len]
    // addition, a[i] 0/1, b[i], 0/1
    // step2: remaining part of a/b,
    // +1
    public String addBinary(String a, String b) {
        int k = Math.min(a.length(), b.length());
        String additional = "0";
        String ans = "";
        for(int i = 1; i <=k; i++){
            String sum = sum(a.substring(a.length()-i, a.length()-i+1),
                    b.substring(b.length()-i, b.length()-i+1), additional);
            if("0".equals(sum) || "1".equals(sum)){
                ans = sum + ans;
                additional = "0";
            }else{
                additional = "1";
                ans = ("2".equals(sum)?"0":"1") + ans;
            }
        }

        String remain = "";
        if(a.length() > b.length()){
            remain = a.substring(0, a.length()-k);
        }else{
            remain = b.substring(0, b.length()-k);
        }

        for(int i = remain.length()-1; i>=0; i--){
            String sum = sum(remain.substring(i, i+1),
                    "0", additional);
            if("0".equals(sum) || "1".equals(sum)){
                ans = sum + ans;
                additional = "0";
            }else{
                additional = "1";
                ans = ("2".equals(sum)?"0":"1") + ans;
            }
        }
        if("1".equals(additional)){
            return "1" + ans;
        }else{
            return ans;
        }
    }

    private String sum(String left, String right, String additional){
        if(left.equals(right)){
            return "0".equals(left)? additional : (additional=="1" ? "3":"2");
        }else{
            return "1".equals(additional) ? "2":"1";
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals("100", sol.addBinary("11","1"));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals("10101", sol.addBinary("1010","1011"));
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        Assert.assertEquals("1000", sol.addBinary("1","111"));
    }

    @Test
    public void test4(){
        Solution sol = new Solution();
        Assert.assertEquals("110001", sol.addBinary("101111","10"));
    }
}
