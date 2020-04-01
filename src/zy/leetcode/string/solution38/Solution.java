package zy.leetcode.string.solution38;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public String countAndSay(int n) {
        return readPre(n);
    }

    private String readPre(int n){
        if(n==1){
            return "1";
        }else if(n==2){
            return "1" + readPre(1);
        }

        String pre = readPre(n-1);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < pre.length();){
            int j = i;
            while(j < pre.length()-1 && pre.substring(j+1,j+2).equals(pre.substring(j,j+1))){
                j++;
            }
            sb.append(j-i+1);
            sb.append(pre.substring(i,i+1));
            i = j+1;
        }
        return sb.toString();
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals("1211", sol.readPre(4));
    }
}
