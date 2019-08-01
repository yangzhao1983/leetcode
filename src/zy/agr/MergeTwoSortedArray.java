package zy.agr;

/**
 * Created by kaiser_zhao on 31/07/2019.
 */
public class MergeTwoSortedArray {

    public static void main(String...strings){
        int[] nums1 = {1,3,5,7,9};
        int[] nums2 = {2,4,6,8,10};
        int[] sorted = mergeTwoSortedArray(nums1, nums2);
        for(int i = 0; i<sorted.length;i++){
            System.out.println(sorted[i]);
        }
    }

    /**
     * two pointers
     * @return
     */
    private static int[] mergeTwoSortedArray(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0){
            return nums2;
        }
        if (nums2 == null || nums2.length == 0){
            return nums1;
        }

        int[] mergedArray = new int[nums1.length + nums2.length];
        int mergedI = 0;
        int i1 = 0, i2=0;
        for(; i1< nums1.length && i2 < nums2.length; mergedI ++){
            if(nums1[i1] > nums2[i2]){
                mergedArray[mergedI] = nums2[i2];
                i2++;
            }else{
                mergedArray[mergedI] = nums1[i1];
                i1++;
            }
        }
        int i = 0;
        int[] nums;
        if(i1 == nums1.length){
            i = i2;
            nums = nums2;
        }else{
            i = i1;
            nums = nums1;
        }
        for (; i < nums.length; i++, mergedI++){
            mergedArray[mergedI] = nums[i];
        }

        return mergedArray;
    }
}
