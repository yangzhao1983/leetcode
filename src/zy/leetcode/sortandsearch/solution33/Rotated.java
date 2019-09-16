package zy.leetcode.sortandsearch.solution33;

/**
 * Created by kaiser_zhao on 2019/9/16.
 */
public class Rotated {

    public static void main(String...strings){
        testcase2();
    }

    private static void testcase1(){
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }

    private static void testcase2(){
        int[] nums = {1,3,5};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return -1;
        }

        return improvedBinarySearch(nums, target, 0, nums.length-1);
    }

    private static int improvedBinarySearch(int[] nums, int target, int left, int right){
        if(nums == null || nums.length == 0){
            return -1;
        }

        if(right - left + 1 <= 2){
            for(int i = left; i <= right; i++){
                if(target == nums[i]){
                    return i;
                }
            }
            return -1;
        }

        int mid = left + (right - left)/2;
        if(nums[mid] == target){
            return mid;
        }else if (nums[left] < nums[mid]){
            if(target >= nums[left] && target < nums[mid]){
                return improvedBinarySearch(nums, target, left, mid-1);
            }else{
                return improvedBinarySearch(nums, target, mid+1, right);
            }
        }else{
            if(target > nums[mid] && target <= nums[right]){
                return improvedBinarySearch(nums, target, mid+1, right);
            }else{
                return improvedBinarySearch(nums, target, left, mid-1);
            }
        }
    }
}
