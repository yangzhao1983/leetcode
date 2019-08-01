package zy.agr;

/**
 * Created by kaiser_zhao on 29/07/2019.
 */
public class BinSearchLoop {
    public static void main(String...strings){
        System.out.println(Integer.MAX_VALUE);
        int[] nums = {1,2,3,4,5,6};
        System.out.println(binSearch(nums, 2));
    }
    
    private static int binSearch(int[]nums, int hkey){
        int start = 0;
        int end = nums.length-1;
        int mid = -1;
        while(start <= end){
            mid = start + (end - start)/2;
            if (nums[mid] == hkey){
                return mid;
            }else if (nums[mid] > hkey){
                end = --mid;
            }else{
                start = ++mid;
            }
        }
        return mid;
    }
}
