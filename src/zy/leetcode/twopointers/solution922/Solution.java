package zy.leetcode.twopointers.solution922;

public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int odd = 1;
        int even = 0;
        int n = A.length;
        while(odd < n && even < n){
            while(odd < n && ((A[odd] + odd)%2==0)) odd +=2 ;
            while(even < n && (A[even] + even)%2==0) even+=2;
            if(odd < n && even < n){
                int temp = A[odd];
                A[odd] = A[even];
                A[even] = temp;
                even+=2;
                odd+=2;
            }
        }
        return A;
    }
}
