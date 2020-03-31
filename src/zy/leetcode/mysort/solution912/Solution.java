package zy.leetcode.mysort.solution912;

import org.junit.Test;

public class Solution {
    // merge sort
    // a[0,(n-1)/2], a[(n-1)/2+1, n]
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private int[] mergeSort(int[] nums, int start, int end){
        int[] rel = new int[end - start+1];

        if(start == end){
            rel[0] = nums[start];
            return rel;
        }

        int[] left = mergeSort(nums, start, start + (end-start)/2);
        int[] right = mergeSort(nums, start + (end-start)/2 + 1, end);

        return merge(left, right);

    }

    private int[] merge(int[] left, int[] right){
        int[] rel = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                rel[k++] = left[i++];
            }else{
                rel[k++] = right[j++];
            }

        }
        if(i==left.length){
            while(j < right.length){
                rel[k++] = right[j++];
            }
        }else{
            while(i < left.length){
                rel[k++] = left[i++];
            }
        }
        return rel;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] rel = sol.sortArray(new int[]{5,2,3,1});

        for(int i : rel){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
}
