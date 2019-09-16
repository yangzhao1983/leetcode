package zy.leetcode.sortandsearch.solution215;

/**
 * Created by kaiser_zhao on 2019/9/16.
 */
public class ByPivot {

    public static void main(String...strings){
        testcase2();
    }

    private static void testcase2(){
        int[] nums = {3,3,3,3,3,3,3,3,3};
        System.out.println(findKthLargest(nums, 2));
    }

    private static void testcase1(){
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while(true){
            int targetPos = pivot(nums, left, right);
            if (k + targetPos == nums.length){
                return nums[targetPos];
            }else if(k + targetPos < nums.length){
                left = targetPos + 1;
            }else{
                right = targetPos - 1;
            }
        }
    }

    private static int pivot(int[] nums, int left, int right){
        if(left == right){
            return left;
        }

        int pivot = nums[left];
        int i = left + 1;
        int j = right;

        while(i < j){
            while(nums[i] <= pivot && i<j) i++;
            while (nums[j] > pivot && i<j) j--;
            if(i==j) break;
            swap(nums, i, j);
        }

        int targetPos = -1;
        if(nums[j] > pivot){
            targetPos = j-1;
        }else{
            targetPos = j;
        }

        swap(nums, left, targetPos);
        return targetPos;
    }

    private static void swap(int[] nums, int src, int tgt){
        int tmp = nums[src];
        nums[src] = nums[tgt];
        nums[tgt] = tmp;
    }
}
