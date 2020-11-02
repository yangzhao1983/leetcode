package zy.leetcode.array.solution941;

public class Solution {
    public boolean validMountainArray(int[] A) {
        boolean ans = false;
        if(A == null || A.length <=2) return ans;
        for(int i = 1; i < A.length-1; i++){
            if(A[i-1] > A[i] && A[i+1] >A[i]){
                return false;
            }else if(A[i-1]==A[i] || A[i+1] == A[i]){
                return false;
            }if(A[i-1] < A[i] && A[i+1] < A[i]){
                ans = true;
            }
        }
        return ans;
    }
}
