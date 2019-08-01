package zy.agr;

/**
 * Created by kaiser_zhao on 29/07/2019.
 */
public class BinSearchRecurse {
    public static void main(String...strings){
        int[] nums = {1,2,3,4,5,6};
        System.out.println(binSearch(0,nums.length, nums, 4));
    }

    private static int binSearch(int start, int end, int[]nums, int hkey){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(nums[mid]>hkey){
            return binSearch(start, mid-1, nums, hkey);
        }
        if (nums[mid]<hkey){
            return binSearch(start+1, end, nums, hkey);
        }
        return mid;
    }
}
