package zy.leetcode.sortandsearch.solution969;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // find the largest one, its index is iMax
    // flip 0->iMax
    // flip 0->len-1
    private int findLargestIndex(int[]A, int end){
        int max = A[0];
        int iMax = 0;
        for(int i = 0; i <= end; i++){
            if(A[i] >max){
                max = A[i];
                iMax = i;
            }
        }
        return iMax;
    }

    private void flipArray(int[] A, int end){
        int mid = (0 + end)/2;
        for(int i = 0; i <= mid; i++){
            int tmp = A[i];
            A[i] = A[end -i];
            A[end -i] = tmp;
        }
    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> rel = new ArrayList<>();
        for(int i = A.length-1; i>0; i--){
            int iMax = findLargestIndex(A, i);
            if(iMax<i){
                if(iMax > 0){
                    flipArray(A, iMax);
                    rel.add(iMax+1);
                }
                flipArray(A, i);
                rel.add(i+1);
            }
        }
        return rel;
    }

    private static void test1(){
        Solution sol = new Solution();
        // 4,2,3,1
        // 1,3,2,4
        // 3,1,2,4
        // 2,1,3,4
        // 1,2,3,4
        List<Integer> rel = sol.pancakeSort(new int[]{3,2,4,1});
        for(int item : rel){
            System.out.println(item);
        }
    }

    public static void main(String...strings){
        test1();
    }

}
