package zy.leetcode.bit.solution191;

public class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        int i = 0;
        int mask = 1;
        while(i++<32){
            if((n & mask) == 1) ans++;
            n >>=1;
        }
        return ans;
    }
}
