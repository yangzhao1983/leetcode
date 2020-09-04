package zy.leetcode.string.solution165;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int compareVersion(String version1, String version2) {
        return doCompare(version1, 0, version2, 0);
    }

    private int doCompare(String v1, int i1, String v2, int i2){
        if(i1 >= v1.length() && i2 >= v2.length()){
            return 0;
        }else if(i1 >= v1.length()){
            return doCompare("0",0, v2, i2);
        }else if(i2 >= v2.length()){
            return doCompare(v1,i1, "0", 0);
        }

        int n1 = 0;
        int i = i1;
        for(; i < v1.length() && v1.charAt(i) != '.'; i++);
        n1 = Integer.parseInt(v1.substring(i1, i));

        int n2 = 0;
        int j = i2;
        for(; j < v2.length() && v2.charAt(j) != '.'; j++);
        n2 = Integer.parseInt(v2.substring(i2, j));

        if(n1 != n2) return n1 > n2? 1: -1;

        return doCompare(v1, i+1, v2, j+1);
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        String version1 = "0.1";
        String version2 = "1.1";
        Assert.assertEquals(-1 , sol.compareVersion(version1, version2));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        String version1 = "1";
        String version2 = "1.0";
        Assert.assertEquals(0 , sol.compareVersion(version1, version2));
    }
}
