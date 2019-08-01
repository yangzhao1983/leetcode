package zy.agr;

import java.util.Arrays;

/**
 * Created by kaiser_zhao on 01/08/2019.
 */
public class MergeSort {

    public static void main(String...strings){
        int[] nums = {6,5,4,3,2,1};
        int[] sortedNums = doMergeSort(nums, 0, nums.length -1);
        Arrays.stream(sortedNums).forEach(item->System.out.println(item));
    }
    private static int[] doMergeSort(int[] nums, int start, int end){
        int[] sortedNums = new int[end-start+1];

        if(start == end){
            sortedNums[0] = nums[start];
        }else{
            int mid = start + (end-start)/2;
            int[] nums1 = doMergeSort(nums, start, mid);
            int[] nums2 = doMergeSort(nums, mid+1, end);
            merge(sortedNums, nums1, nums2);
        }

        return sortedNums;
    }

    private static void merge(int[] nums, int[] nums1, int[] nums2){
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        for(; i1 < nums1.length && i2 < nums2.length; i++){
            nums[i] = nums1[i1] > nums2[i2] ? nums2[i2++] : nums1[i1++];
        }

        while(i1 < nums1.length){
            nums[i++] = nums1[i1++];
        }
        while(i2 < nums2.length){
            nums[i++] = nums2[i2++];
        }
    }
}
