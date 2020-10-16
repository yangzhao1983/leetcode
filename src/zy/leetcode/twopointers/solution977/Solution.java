package zy.leetcode.twopointers.solution977;

public class Solution {
    public int[] sortedSquares(int[] A) {
        if(A==null || A.length == 0) return new int[0];
        int n = A.length;
        int[] ans = new int[n];
        int cur = n-1;
        int l = 0;
        int r = n-1;
        while(l < r){
            if( A[l] >=0){
                break;
            } else if(Math.abs(A[l]) > Math.abs(A[r])){
                ans[cur--] = A[l] * A[l];
                l++;
            }else{
                ans[cur--] = A[r] * A[r];
                r--;
            }
        }
        for(int i=r; i>=l; i--){
            ans[cur--] = A[i] * A[i];
        }
        return ans;
    }
}
