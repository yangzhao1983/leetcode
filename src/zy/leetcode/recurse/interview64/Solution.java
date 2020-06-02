package zy.leetcode.recurse.interview64;

public class Solution {
    public int sumNums(int n) {
        boolean rel = n>0 && (( n = sumNums(n-1) + n)>0);
        return n;
    }
}
