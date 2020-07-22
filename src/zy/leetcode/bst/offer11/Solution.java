package zy.leetcode.bst.offer11;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;
import org.junit.Assert;
import org.junit.Test;

import java.util.EnumSet;

public class Solution {

    private int[] numbers;

    public int minArray(int[] numbers) {
        this.numbers = numbers;
        return doSearch(0, numbers.length-1);
    }

    private int doSearch(int l, int r){
        if(l==r) return numbers[l];
        else if(r==l+1) return Math.min(numbers[l], numbers[r]);

        int mid = l + (r-l)/2;
        if(numbers[l] > numbers[mid]) return doSearch(l, mid);
        else if(numbers[mid] > numbers[r]) return doSearch(mid, r);
        else return Math.min(doSearch(l, mid), doSearch(mid+1,r));
    }

    /**
     * mid < l, mid <r
     *
     */
    @Test
    public void test1(){
        int[] numbers = {4,5,6,1,2,3};
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.minArray(numbers));
    }

    /**
     * mid > l, mid >r
     */
    @Test
    public void test2(){
        int[] numbers = {4,5,6,1};
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.minArray(numbers));
    }

    /**
     * mid < r, mid >l
     */
    @Test
    public void test3(){
        int[] numbers = {1,2,3};
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.minArray(numbers));
    }


    @Test
    public void test4(){
        int[] numbers = {5,6,1,2,3,4};
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.minArray(numbers));
    }

    @Test
    public void test5(){
        int[] numbers = {3,3,1,3};
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.minArray(numbers));
    }
}
